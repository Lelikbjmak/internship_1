package com.innowise.ball_factory.comparator;

import java.util.Map;

public interface Prioritized<T> {

    Map<T, Integer> getCustomPriorityMap(Map<T, Integer> customPriorityMap);

    Map<T, Integer> getAscPriorityMap();

    Map<T, Integer> getDescPriorityMap();

}
