package ball.sorts.quick;

import ball.entity.ball_comparator.ComparatorType;

import java.util.Comparator;
import java.util.List;

/**
 * QuickSort algorithm, (recursion)
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class QuickSort<T> {

    private final Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(List<T> balls) {
        final int last = balls.size() - 1;
        quickSort(balls, 0, last);
    }

    /**
     * @param objects - our List, with balls to sort.
     * @param first   - first index of bound(subList) we're sort.
     * @param last    - last index of bound(subList) we're sorting.
     * @method quickSort - Implementation of QuickSort.
     * {@link  ComparatorType} - Use to build a {@link Comparator}, that provides us with custom Comparator type hence we choose ASC/DESC sort.
     */
    private void quickSort(List<T> objects, int first, int last) {

        int f = first;
        int l = last;

        T mid = objects.get((f + l) / 2); // frame element

        while (f < l) {
            while (comparator.compare(objects.get(f), mid) < 0) f++;
            while (comparator.compare(objects.get(l), mid) > 0) l--;

            if (f <= l) { // swap elements
                swap(objects, f, l);
                f++;
                l--;
            }
        }
        if (first < l) quickSort(objects, first, l);
        if (f < last) quickSort(objects, f, last);
    }

    /**
     * @method swap() - swap elements in List
     */
    private void swap(List<T> balls, int left, int right) {
        T ball = balls.get(left);
        balls.set(left, balls.get(right));
        balls.set(right, ball);
    }
}
