package ball.sorts;

import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.List;

// TODO: Add other types of sorts
public class SortingAlgorithm {

    public static void quickSort(List<Ball> balls, Comparator<Ball> ballComparator) {
        QuickSort.sort(balls, ballComparator);
    }
}
