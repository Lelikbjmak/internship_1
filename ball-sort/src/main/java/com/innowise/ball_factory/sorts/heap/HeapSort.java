package com.innowise.ball_factory.sorts.heap;

import com.innowise.ball_factory.sorts.Sorter;

import java.util.Comparator;
import java.util.List;

/**
 * HeapSort - heap sort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class HeapSort<T> implements Sorter<T> {

    /**
     * @param objectList Objects we are sorting
     */
    private List<T> heapSort(List<T> objectList, Comparator<T> objectComparator) {

        int listSize = objectList.size();
        buildBinaryHeap(objectList, listSize, objectComparator);

        T object;
        for (int i = listSize - 1; i > 0; i--) {
            object = objectList.get(0);
            objectList.set(0, objectList.get(i));
            objectList.set(i, object);
            heap(objectList, i, 0, objectComparator);
        }

        return objectList;
    }

    private void heap(List<T> objectList, int treeLength, int currentNodeIndex,
                      Comparator<T> comparator) {

        int greatestNodeIndex = currentNodeIndex;
        // Due to the fact that we have binary tree. Each has(may) two child nodes
        int leftChildNodeIndex = 2 * currentNodeIndex + 1; // left child elementIndex
        int rightChildNodeIndex = 2 * currentNodeIndex + 2; // right child elementIndex

        // If left node > root
        if (leftChildNodeIndex < treeLength &&
                comparator.compare(objectList.get(leftChildNodeIndex), objectList.get(greatestNodeIndex)) > 0)
            greatestNodeIndex = leftChildNodeIndex;

        // If right node > greatestIndex so far
        if (rightChildNodeIndex < treeLength &&
                comparator.compare(objectList.get(rightChildNodeIndex), objectList.get(greatestNodeIndex)) > 0)
            greatestNodeIndex = rightChildNodeIndex;

        // If greatestNode is not root
        if (greatestNodeIndex != currentNodeIndex) {
            swapParentAndChildNode(objectList, currentNodeIndex, greatestNodeIndex);
            heap(objectList, treeLength, greatestNodeIndex, comparator);
        }
    }

    private void buildBinaryHeap(List<T> objectList, int listSize, Comparator<T> objectComparator) {
        for (int i = listSize / 2 - 1; i >= 0; i--)
            heap(objectList, listSize, i, objectComparator);
    }

    private void swapParentAndChildNode(List<T> objectList, int currentNodeIndex, int greatestNodeIndex) {
        T greatestNode = objectList.get(currentNodeIndex);
        objectList.set(currentNodeIndex, objectList.get(greatestNodeIndex));
        objectList.set(greatestNodeIndex, greatestNode);
    }

    @Override
    public List<T> sort(List<T> objectList, Comparator<T> objectComparator) {
        return heapSort(objectList, objectComparator);
    }
}
