package com.innowise.ball_factory.sorts.quick;

import java.util.Comparator;
import java.util.List;

/**
 * QuickSort parallel
 */
public class QuickSortParallel<T> {

    private final Comparator<T> comparator;

    public QuickSortParallel(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @param objects Collection of Objects we are sorting
     */
    public void quickSort(List<T> objects) {
        new QuickSortThread<>(objects, 0, objects.size() - 1, comparator)
                .sort(0, objects.size() - 1, comparator);
    }
}
