package com.innowise.ball_factory.service;

import com.innowise.ball_factory.sorts.Sortable;

import java.util.Comparator;
import java.util.List;

public class SortingService<T> {

    public List<T> sort(Sortable<T> sortAlgorithm, List<T> objectList, Comparator<T> objectComparator) {
        return sortAlgorithm.sort(objectList, objectComparator);
    }
}
