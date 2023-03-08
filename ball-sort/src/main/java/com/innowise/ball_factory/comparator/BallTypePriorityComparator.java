package com.innowise.ball_factory.comparator;

import com.innowise.ball_factory.entity.Ball;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;

import java.util.Map;

public class BallTypePriorityComparator implements BallComparator {

    private final Map<Type, Integer> typePriorityMap;

    public BallTypePriorityComparator(Prioritized<Type> typePriorityMapBuilder,
                                      Map<Type, Integer> customTypePriorityMap) {
        this.typePriorityMap = typePriorityMapBuilder
                .getCustomPriorityMap(customTypePriorityMap);
    }

    public BallTypePriorityComparator(Prioritized<Type> typePriorityMapBuilder, boolean toLargeSport) {
        if (toLargeSport)
            this.typePriorityMap = typePriorityMapBuilder.getAscPriorityMap();
        else
            this.typePriorityMap = typePriorityMapBuilder.getDescPriorityMap();
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        Integer firstBallTypePriority = typePriorityMap.get(o1.getType());
        Integer secondBallTypePriority = typePriorityMap.get(o2.getType());
        return firstBallTypePriority.compareTo(secondBallTypePriority);
    }

}
