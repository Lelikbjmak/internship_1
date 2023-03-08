package ball.sorts.merge;

import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MergeSortParallel {

    private final Comparator<Ball> comparator;

    public MergeSortParallel(Comparator<Ball> comparator) {
        this.comparator = comparator;
    }

    public void mergeSort(List<Ball> balls) {

        Ball[] ballArray = balls.toArray(new Ball[0]);
        ParallelMergeThread mainTask = new ParallelMergeThread(ballArray, comparator);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

        for (int i = 0; i < ballArray.length; i++)
            balls.set(i, ballArray[i]);

    }
}
