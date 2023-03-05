package ball.sorts;

import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.List;

/**
 * QuickSort algorithm, (recursion)
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class QuickSort {

    public static void sort(List<Ball> balls, Comparator<Ball> comparator) {
        final int last = balls.size() - 1;
        quickSort(balls, 0, last, comparator);
    }

    /**
     * @param balls          - our List, with balls to sort.
     * @param first          - first index of bound(subList) we're sort.
     * @param last           - last index of bound(subList) we're sorting.
     * @param ballComparator - custom Comparator to compare balls with each other.
     * @method quickSort - Implementation of QuickSort.
     * {@link  ComparatorType} - Use to build a {@link Comparator}, that provides us with custom Comparator type hence we choose ASC/DESC sort.
     */
    private static void quickSort(List<Ball> balls, int first, int last, Comparator<Ball> ballComparator) {

        int f = first, l = last;
        Ball mid = balls.get((f + l) / 2); // frame element

        while (f < l) {
            while (ballComparator.compare(balls.get(f), mid) < 0) f++;
            while (ballComparator.compare(balls.get(l), mid) > 0) l--;

            if (f <= l) { // swap elements
                swap(balls, f, l);
                f++;
                l--;
            }
        }
        if (first < l) quickSort(balls, first, l, ballComparator);
        if (f < last) quickSort(balls, f, last, ballComparator);
    }

    /**
     * @method swap() - swap elements in List
     */
    private static void swap(List<Ball> balls, int left, int right) {
        Ball ball = balls.get(left);
        balls.set(left, balls.get(right));
        balls.set(right, ball);
    }
}
