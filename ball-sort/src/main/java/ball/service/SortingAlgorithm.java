package ball.service;

import ball.sorts.binary_tree.TreeSort;
import ball.sorts.heap.HeapSort;
import ball.sorts.merge.MergeSort;
import ball.sorts.odd_even.OddEvenSort;
import ball.sorts.quick.QuickSort;
import ball.sorts.quick.QuickSortParallel;

import java.util.Comparator;
import java.util.List;

public class SortingAlgorithm {

    private SortingAlgorithm() {
        throw new IllegalArgumentException(this.getClass() + " is Util class.");
    }

    public static <T> void quickSort(List<T> objects, Comparator<T> comparator) {
        QuickSort<T> quickSort = new QuickSort<>(comparator);
        quickSort.sort(objects);
    }

    public static <T> void parallelQuickSort(List<T> objects, Comparator<T> comparator) {
        QuickSortParallel<T> quickSortParallel = new QuickSortParallel<>(comparator);
        quickSortParallel.quickSort(objects);
    }

    public static <T> void mergeSort(List<T> objects, Comparator<T> comparator) {
        MergeSort<T> mergeSort = new MergeSort<>(comparator);
        mergeSort.mergeSort(objects);
    }

    public static <T> void oddEvenSort(List<T> objects, Comparator<T> comparator) {
        OddEvenSort<T> oddEvenSort = new OddEvenSort<>(comparator);
        oddEvenSort.oddEvenSort(objects);
    }

    public static <T> void heapSort(List<T> objects, Comparator<T> comparator) {
        HeapSort<T> heapSort = new HeapSort<>(comparator);
        heapSort.heapSort(objects);
    }

    public static <T> void treeSort(List<T> objects, Comparator<T> comparator) {
        TreeSort<T> treeSort = new TreeSort<>(comparator);
        treeSort.treeSort(objects);
    }
}
