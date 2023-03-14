package com.innowise.ball_factory.sorts.quick;

import com.innowise.ball_factory.sorts.Sorter;

import java.util.Comparator;
import java.util.List;

/**
 * QuickSort algorithm, (recursion)
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class QuickSort<T> implements Sorter<T> {

    /**
     * @param objects         Our List, with objects we are sorting
     * @param beginBoundIndex First index of bound(subList) we're sort.
     * @param lastBoundIndex  Last index of bound(subList) we're sorting.
     * @method quickSort() - Implementation of QuickSort.
     * {@link  } - Use to build a {@link Comparator}, that provides us with custom Comparator type hence we choose ASC/DESC sort.
     */
    private List<T> quickSort(List<T> objects, Comparator<T> comparator, int beginBoundIndex, int lastBoundIndex) {

        int elementGreaterThanMidIndex = beginBoundIndex;
        int elementLessThanMidIndex = lastBoundIndex;

        T mid = getFrameElement(objects, beginBoundIndex, lastBoundIndex); // frame element

        while (elementGreaterThanMidIndex < elementLessThanMidIndex) {

            while (comparator.compare(objects.get(elementGreaterThanMidIndex), mid) < 0)
                elementGreaterThanMidIndex++;

            while (comparator.compare(objects.get(elementLessThanMidIndex), mid) > 0)
                elementLessThanMidIndex--;

            if (elementGreaterThanMidIndex <= elementLessThanMidIndex) { // swap elements
                swap(objects, elementGreaterThanMidIndex, elementLessThanMidIndex);
                elementGreaterThanMidIndex++;
                elementLessThanMidIndex--;
            }
        }

        if (beginBoundIndex < elementLessThanMidIndex)
            quickSort(objects, comparator, beginBoundIndex, elementLessThanMidIndex);
        if (elementGreaterThanMidIndex < lastBoundIndex)
            quickSort(objects, comparator, elementGreaterThanMidIndex, lastBoundIndex);

        return objects;
    }

    private T getFrameElement(List<T> objectList, int begin, int end) {
        return objectList.get((begin + end) / 2);
    }

    /**
     * @method swap() - swap elements in List
     */
    private void swap(List<T> balls, int left, int right) {
        T ball = balls.get(left);
        balls.set(left, balls.get(right));
        balls.set(right, ball);
    }

    @Override
    public List<T> sort(List<T> objectList, Comparator<T> objectComparator) {
        final int last = objectList.size() - 1;
        final int begin = 0;
        return quickSort(objectList, objectComparator, begin, last);
    }
}
