package ball.service;

import ball.entity.balls.Ball;
import ball.sorts.merge.MergeSort;
import ball.sorts.quick.QuickSort;

import java.util.Comparator;
import java.util.List;

// TODO: Add other types of sorts
public class SortingAlgorithm {

    public static void quickSort(List<Ball> balls, Comparator<Ball> ballComparator) {
        QuickSort.sort(balls, ballComparator);
    }

    public static void mergeSort(List<Ball> balls, Comparator<Ball> ballComparator) {
        MergeSort.mergeSort(balls, ballComparator);
    }
}
