package com.innowise.ball_factory.sorts;

import java.util.Comparator;
import java.util.List;

public interface Sortable<T> {

    List<T> sort(List<T> objectList, Comparator<T> objectComparator);

}
