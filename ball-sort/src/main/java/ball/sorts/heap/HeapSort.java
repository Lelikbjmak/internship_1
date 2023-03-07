package ball.sorts.heap;

import java.util.Comparator;
import java.util.List;

/**
 * HeapSort - heap sort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class HeapSort<T> {

    private final Comparator<T> comparator;

    public HeapSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @param objects Objects we are sorting
     */
    public void heapSort(List<T> objects) {

        int n = objects.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heap(objects, n, i, comparator);


        for (int i = n - 1; i > 0; i--) {
            T object = objects.get(0);
            objects.set(0, objects.get(i));
            objects.set(i, object);
            heap(objects, i, 0, comparator);
        }
    }

    private void heap(List<T> objects, int n, int i,
                      Comparator<T> comparator) {

        int largest = i;
        int l = 2 * i + 1; // left child element
        int r = 2 * i + 2; // right child element

        // If left node > root
        if (l < n &&
                comparator.compare(objects.get(l), objects.get(largest)) > 0)
            largest = l;

        // If right node > largest so far
        if (r < n &&
                comparator.compare(objects.get(r), objects.get(largest)) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            T object = objects.get(i);
            objects.set(i, objects.get(largest));
            objects.set(largest, object);
            heap(objects, n, largest, comparator);
        }
    }

}
