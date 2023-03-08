package com.innowise.ball_factory.sorts.odd_even;

import com.innowise.ball_factory.sorts.Sortable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * OddEvenSort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class OddEvenSort<T> implements Sortable<T> {

    /**
     * @method oddEvenSort() sort function
     * @param objectList Objects we are sorting
     * @param objectComparator Comparator to compare objects with each other
     */
    private List<T> oddEvenSort(List<T> objectList, Comparator<T> objectComparator) {

        boolean isListSorted = false;
        int objectListSize = objectList.size();

        while (!isListSorted) {

            isListSorted = sortOddListElements(objectList, objectListSize, objectComparator);

            isListSorted = sortEvenListElements(objectList, objectListSize, objectComparator);
        }

        return objectList;
    }

    @Override
    public List<T> sort(List<T> objectList, Comparator<T> objectComparator) {
        return oddEvenSort(objectList, objectComparator);
    }

    private boolean sortOddListElements(List<T> objectList, int objectListSize,
                                        Comparator<T> objectComparator) {
        boolean isOddElementsSorted = true;

        for (int i = 1; i < objectListSize - 1; i += 2) {
            if (objectComparator.compare(objectList.get(i), objectList.get(i + 1)) > 0) {
                Collections.swap(objectList, i, i + 1);
                isOddElementsSorted = false;
            }
        }
        return isOddElementsSorted;
    }

    private boolean sortEvenListElements(List<T> objectList, int objectListSize,
                                         Comparator<T> objectComparator) {
        boolean isEvenElementsSorted = true;

        for (int i = 0; i < objectListSize - 1; i += 2) {
            if (objectComparator.compare(objectList.get(i), objectList.get(i + 1)) > 0) {
                Collections.swap(objectList, i, i + 1);
                isEvenElementsSorted = false;
            }
        }
        return isEvenElementsSorted;
    }
}
