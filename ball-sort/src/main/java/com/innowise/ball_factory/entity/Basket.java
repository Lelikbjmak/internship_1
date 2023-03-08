package com.innowise.ball_factory.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Basket - Stash all our {@link Ball}
 */
public class Basket<T> {

    private List<T> objectList;

    public Basket() {
        objectList = new ArrayList<>();
    }

    public void setBalls(List<T> objectList) {
        this.objectList = objectList;
    }

    public List<T> getObjectList() {
        return objectList;
    }
}
