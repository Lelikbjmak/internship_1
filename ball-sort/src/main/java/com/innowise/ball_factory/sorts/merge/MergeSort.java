package com.innowise.ball_factory.sorts.merge;

import com.innowise.ball_factory.sorts.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MergeSort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class MergeSort<T> implements Sorter<T> {

    /**
     * @param objectList Initial List with objects
     * @method mergeSort() Divide initial List with balls recursively into several subLists to sort them separately
     */
    private List<T> mergeSort(List<T> objectList, Comparator<T> objectComparator) {

        List<T> leftSubList = new ArrayList<>();
        List<T> rightSubList = new ArrayList<>();

        if (objectList.size() < 2) {
            return objectList;
        }

        int midElementIndex = objectList.size() / 2;

        for (int i = 0; i < midElementIndex; i++) {
            leftSubList.add(objectList.get(i));
        }

        for (int i = midElementIndex; i < objectList.size(); i++) {
            rightSubList.add(objectList.get(i));
        }

        mergeSort(leftSubList, objectComparator);
        mergeSort(rightSubList, objectComparator);
        merge(leftSubList, rightSubList, objectList, objectComparator);

        return objectList;
    }

    /**
     * @param leftObjectList  Left SubList with balls
     * @param rightObjectList Right SubList with balls
     * @param initialList     Initial List with balls
     * @method merge() Merge 2 lists into one
     */
    private void merge(List<T> leftObjectList, List<T> rightObjectList,
                       List<T> initialList, Comparator<T> objectComparator) {

        int left = 0;
        int right = 0;

        int res = 0;

        while (left < leftObjectList.size() && right < rightObjectList.size()) {

            if (objectComparator.compare(leftObjectList.get(left), rightObjectList.get(right)) < 0) {
                initialList.set(res, leftObjectList.get(left));
                left++;
            } else {
                initialList.set(res, rightObjectList.get(right));
                right++;
            }
            res++;
        }

        while (left < leftObjectList.size()) {
            initialList.set(res, leftObjectList.get(left));
            res++;
            left++;
        }
        while (right < rightObjectList.size()) {
            initialList.set(res, rightObjectList.get(right));
            res++;
            right++;
        }
    }

    @Override
    public List<T> sort(List<T> objectList, Comparator<T> objectComparator) {
        return mergeSort(objectList, objectComparator);
    }
}
