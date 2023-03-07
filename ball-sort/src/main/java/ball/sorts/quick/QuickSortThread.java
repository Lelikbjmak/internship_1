package ball.sorts.quick;

import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.List;

public class QuickSortThread<T> extends Thread {

    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();

    private final List<T> objects;

    private final int f; // left index

    private final int l; // right index

    private static int threadCount = 0;  // current Threads count

    private final Comparator<T> comparator; // comparator

    private static synchronized void incThreadCount() {
        threadCount += 2;
    }

    private static synchronized void decThreadCount() {
        threadCount -= 2;
    }

    private synchronized boolean isThreadAllowed() {
        return threadCount <= MAX_THREADS;
    }

    public QuickSortThread(List<T> objects, int f, int l, Comparator<T> comparator) {
        this.objects = objects;
        this.f = f;
        this.l = l;
        this.comparator = comparator;
    }

    /**
     * @param f          Left element index
     * @param l          Right element index
     * @param comparator Comparator for objects
     */
    public void sort(int f, int l, Comparator<T> comparator) {

        if (f < l) {
            int mid = partition(f, l, comparator);
            if (isThreadAllowed()) {
                incThreadCount();
                new QuickSortThread<>(objects, f, mid - 1, comparator).start();
                new QuickSortThread<>(objects, mid + 1, l, comparator).start();
                decThreadCount();
            } else {
                sort(f, mid - 1, comparator);
                sort(mid + 1, l, comparator);
            }
        }
    }

    /**
     * @param pLeft      left bound index
     * @param pRight     right bound index
     * @param comparator Comparator for {@link Ball}
     * @return Index between two bounds to sort
     */
    private int partition(int pLeft, int pRight, Comparator<T> comparator) {
        T pivotValue = objects.get(pRight);
        int storeIndex = pLeft;
        for (int i = pLeft; i < pRight; i++) {
            if (comparator.compare(objects.get(i), pivotValue) < 0) {
                swap(i, storeIndex);
                storeIndex++;
            }
        }
        swap(storeIndex, pRight);
        return storeIndex;
    }

    /**
     * @param left  left element
     * @param right right element
     */
    private void swap(int left, int right) {
        T temp = objects.get(left);
        objects.set(left, objects.get(right));
        objects.set(right, temp);
    }

    @Override
    public void run() {
        sort(f, l, comparator);
    }

}
