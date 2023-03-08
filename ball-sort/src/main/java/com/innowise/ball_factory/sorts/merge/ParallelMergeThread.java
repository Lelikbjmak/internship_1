package com.innowise.ball_factory.sorts.merge;

import com.innowise.ball_factory.entity.Ball;

import java.util.Comparator;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeThread extends RecursiveAction {

    private final Ball[] array;

    private final Comparator<Ball> comparator;

    public ParallelMergeThread(Ball[] array, Comparator<Ball> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    @Override
    protected void compute() {

        if (array.length < 2)
            return;

        int mid = array.length / 2;

        Ball[] firstHalf = new Ball[mid];
        System.arraycopy(array, 0, firstHalf, 0, mid);

        Ball[] secondHalf = new Ball[array.length - mid];
        System.arraycopy(array, mid, secondHalf, 0, array.length - mid);

        ParallelMergeThread firstHalfTask = new ParallelMergeThread(firstHalf, comparator);
        ParallelMergeThread secondHalfTask = new ParallelMergeThread(secondHalf, comparator);

        invokeAll(firstHalfTask, secondHalfTask);

        merge(firstHalf, secondHalf, array);
    }

    public void merge(Ball[] firstHalf, Ball[] secondHalf, Ball[] array) {

        int currentIndexFirst = 0;
        int currentIndexSecond = 0;
        int currentIndexArray = 0;

        while (currentIndexFirst < firstHalf.length && currentIndexSecond < secondHalf.length) {
            if (comparator.compare(firstHalf[currentIndexFirst], secondHalf[currentIndexSecond]) < 0) {
                array[currentIndexArray] = firstHalf[currentIndexFirst];
                currentIndexArray++;
                currentIndexFirst++;
            } else {
                array[currentIndexArray] = secondHalf[currentIndexSecond];
                currentIndexArray++;
                currentIndexSecond++;
            }
        }

        while (currentIndexFirst < firstHalf.length) {
            array[currentIndexArray] = firstHalf[currentIndexFirst];
            currentIndexArray++;
            currentIndexFirst++;
        }

        while (currentIndexSecond < secondHalf.length) {
            array[currentIndexArray] = secondHalf[currentIndexSecond];
            currentIndexArray++;
            currentIndexSecond++;
        }
    }
}
