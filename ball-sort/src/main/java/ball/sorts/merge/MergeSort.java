package ball.sorts.merge;

import ball.entity.balls.Ball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MergeSort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class MergeSort {

    /**
     * @method mergeSort - divide initial List with balls recursively into several subLists to sort them separately
     * @param balls Initial List with balls
     * @param ballComparator Comparator to compare balls with each other
     */
    public static void mergeSort(List<Ball> balls, Comparator<Ball> ballComparator) {

        List<Ball> leftSubList = new ArrayList<>();
        List<Ball> rightSubList = new ArrayList<>();

        int mid;

        if (balls.size() != 1) {
            mid = balls.size() / 2;

            for (int i = 0; i < mid; i++) {
                leftSubList.add(balls.get(i));
            }

            for (int i = mid; i < balls.size(); i++) {
                rightSubList.add(balls.get(i));
            }

            mergeSort(leftSubList, ballComparator);
            mergeSort(rightSubList, ballComparator);
            merge(leftSubList, rightSubList, balls, ballComparator);
        }
    }

    /**
     * @method merge - merge 2 lists into one
     * @param leftBallList - left SubList with balls
     * @param rightBallList - right SubList with balls
     * @param balls - initial List with balls
     * @param ballComparator - ball Comparator
     */
    private static void merge(List<Ball> leftBallList, List<Ball> rightBallList, List<Ball> balls, Comparator<Ball> ballComparator) {

        int left = 0;
        int right = 0;

        int res = 0;

        while (left < leftBallList.size() && right < rightBallList.size()) {

            if (ballComparator.compare(leftBallList.get(left), rightBallList.get(right)) < 0) {
                balls.set(res, leftBallList.get(left));
                left++;
            } else {
                balls.set(res, rightBallList.get(right));
                right++;
            }
            res++;
        }

        while (left < leftBallList.size()) {
            balls.set(res, leftBallList.get(left));
            res++;
            left++;
        }
        while (right < rightBallList.size()) {
            balls.set(res, rightBallList.get(right));
            res++;
            right++;
        }
    }

}
