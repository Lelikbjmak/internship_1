package com.innowise.ball_factory.comparator;

import com.innowise.ball_factory.entity.Ball;

public class BallColorComparator implements BallComparator {

    @Override
    public int compare(Ball o1, Ball o2) {
        return o1.getColor().name().compareTo(o2.getColor().name());
    }
}
