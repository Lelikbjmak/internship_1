package com.innowise.ball_factory.service;

import com.innowise.ball_factory.sorts.Sorter;

import java.util.Comparator;
import java.util.List;

public class SortingService<T> {

    public List<T> sort(Sorter<T> sortAlgorithm, List<T> objectList, Comparator<T> objectComparator) {
        return sortAlgorithm.sort(objectList, objectComparator);
    }

    public List<T> sort(Sorter<T> sortAlgorithm, List<T> objectList) {
        return sortAlgorithm.sort(objectList, (o1, o2) -> 0);
    }
}
