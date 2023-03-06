package ball.sorts.quick;

import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.List;

/**
 * QuickSort parallel
 */
public class QuickSortParallel {

    /**
     * @param balls          Collection of Balls we are sorting
     * @param ballComparator Ball comparator we use to compare elements with each other
     */
    public static void quickSort(List<Ball> balls, Comparator<Ball> ballComparator) {
        new Sorter(balls, 0, balls.size() - 1, ballComparator)
                .sort(0, balls.size() - 1, ballComparator);
    }

    /**
     * Sort thread
     */
    static class Sorter extends Thread {

        // all available threads
        private static final int THREAD_LIMIT = Runtime.getRuntime().availableProcessors();

        private final List<Ball> balls;

        private final int f; // left index

        private final int l; // right index

        private static int threadCount = 0;  // current Threads count

        private final Comparator<Ball> ballComparator; // comparator

        private synchronized static void incThreadCount() {
            threadCount += 2;
        }

        private synchronized static void decThreadCount() {
            threadCount -= 2;
        }

        private synchronized boolean isThreadAllowed() {
            return threadCount <= THREAD_LIMIT;
        }

        public Sorter(List<Ball> balls, int f, int l, Comparator<Ball> ballComparator) {
            this.balls = balls;
            this.f = f;
            this.l = l;
            this.ballComparator = ballComparator;
        }

        /**
         *
         * @param f left element index
         * @param l right element index
         * @param ballComparator comparator
         */
        void sort(int f, int l, Comparator<Ball> ballComparator) {

            if (f < l) {
                int mid = partition(f, l, ballComparator);
                if (isThreadAllowed()) {
                    incThreadCount();
                    new Sorter(balls, f, mid - 1, ballComparator).start();
                    new Sorter(balls, mid + 1, l, ballComparator).start();
                    decThreadCount();
                } else {
                    sort(f, mid - 1, ballComparator);
                    sort(mid + 1, l, ballComparator);
                }
            }
        }

        /**
         * @param pLeft left bound index
         * @param pRight right bound index
         * @param ballComparator Comparator for {@link Ball}
         * @return Index between two bounds to sort
         */
        private int partition(int pLeft, int pRight, Comparator<Ball> ballComparator) {
            Ball pivotValue = balls.get(pRight);
            int storeIndex = pLeft;
            for (int i = pLeft; i < pRight; i++) {
                if (ballComparator.compare(balls.get(i), pivotValue) < 0) {
                    swap(i, storeIndex);
                    storeIndex++;
                }
            }
            swap(storeIndex, pRight);
            return storeIndex;
        }

        /**
         * @param left left element
         * @param right right element
         */
        private void swap(int left, int right) {
            Ball temp = balls.get(left);
            balls.set(left, balls.get(right));
            balls.set(right, temp);
        }

        @Override
        public void run() {
            sort(f, l, ballComparator);
        }
    }
}
