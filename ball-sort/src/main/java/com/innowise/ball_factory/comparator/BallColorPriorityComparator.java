package com.innowise.ball_factory.comparator;

import com.innowise.ball_factory.entity.Ball;
import com.innowise.ball_factory.entity.ball_const_field_types.Color;

import java.util.Map;

public class BallColorPriorityComparator implements BallComparator {

    private final Map<Color, Integer> colorPriorityMap;

    public BallColorPriorityComparator(Prioritized<Color> colorPriorityMapBuilder,
                                       Map<Color, Integer> customColorPriorityMap) {
        this.colorPriorityMap = colorPriorityMapBuilder
                .getCustomPriorityMap(customColorPriorityMap);
    }

    public BallColorPriorityComparator(Prioritized<Color> colorPriorityMapBuilder, boolean toLightColor) {
        if (toLightColor)
            this.colorPriorityMap = colorPriorityMapBuilder.getAscPriorityMap();
        else
            this.colorPriorityMap = colorPriorityMapBuilder.getDescPriorityMap();
    }

    @Override
    public int compare(Ball o1, Ball o2) {
        Integer firstBallColorPriority = colorPriorityMap.get(o1.getColor());
        Integer secondBallColorPriority = colorPriorityMap.get(o2.getColor());
        return firstBallColorPriority.compareTo(secondBallColorPriority);
    }
}
