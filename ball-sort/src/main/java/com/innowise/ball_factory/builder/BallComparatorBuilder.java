package com.innowise.ball_factory.builder;

import com.innowise.ball_factory.comparator.*;
import com.innowise.ball_factory.entity.Ball;
import com.innowise.ball_factory.entity.ball_const_field_types.Color;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;

import java.util.Comparator;
import java.util.Map;

/**
 * Ball Comparator Utils - provides us with default business logic for
 *
 * @see BallComparator
 */
public class BallComparatorBuilder {

    public BallComparator nameComparator() {
        return new BallNameComparator();
    }

    public BallComparator weightComparator() {
        return new BallWeightComparator();
    }

    public BallComparator circumferenceComparator() {
        return new BallCircumferenceComparator();
    }

    public BallComparator typeComparator() {
        return new BallTypeComparator();
    }

    public BallComparator colorComparator() {
        return new BallColorComparator();
    }

    public BallComparator customTypePriorityComparator(Map<Type, Integer> typePriorityMap) {
        return new BallTypePriorityComparator(new TypePriorityBuilder(), typePriorityMap);
    }

    public BallComparator typePriorityComparator(boolean toLargeSport) {
        return new BallTypePriorityComparator(new TypePriorityBuilder(), toLargeSport);
    }

    public BallComparator colorPriorityComparator(Map<Color, Integer> colorPriorityMap) {
        return new BallColorPriorityComparator(new ColorPriorityBuilder(), colorPriorityMap);
    }

    public BallComparator colorPriorityComparator(boolean toLightColor) {
        return new BallColorPriorityComparator(new ColorPriorityBuilder(), toLightColor);
    }

    public Comparator<Ball> comparatorChain(Comparator<Ball>... comparators) {

        if (comparators.length < 1)
            return new BallNameComparator();

        Comparator<Ball> comparatorChain = comparators[0];

        for (int i = 1; i < comparators.length; i++) {
            comparatorChain = comparatorChain
                    .thenComparing(comparators[i]);
        }

        return comparatorChain;
    }
}
