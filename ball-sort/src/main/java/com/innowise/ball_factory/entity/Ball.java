package com.innowise.ball_factory.entity;

import com.innowise.ball_factory.entity.ball_const_field_types.Color;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;

import java.util.Objects;

/**
 * Ball - frame for all Balls we have.
 */
public class Ball implements Comparable<Ball> {

    public Ball(String name, double circumference,
                double weight, Color color, Type type) {
        this.type = type;
        this.name = name;
        this.circumference = circumference;
        this.weight = weight;
        this.color = color;
    }

    protected String name;

    protected Color color;

    protected Type type;

    protected Double circumference;

    protected Double weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Double getCircumference() {
        return circumference;
    }

    public Double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nName: " + name + "\nType: " + type.name() + "\nColor: "
                + color.name() + "\nWeight: " + weight + "\nCircumference: " + circumference;
    }

    public int compareTo(Ball o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(name, ball.name) && color == ball.color && type == ball.type && Objects.equals(circumference, ball.circumference) && Objects.equals(weight, ball.weight);
    }

    @Override
    public int hashCode() {
        final int primeNumber = 37;
        int hash = 1;
        hash = primeNumber * hash + this.name.hashCode();
        hash = primeNumber * hash + this.type.hashCode();
        hash = primeNumber * hash + this.color.hashCode();
        hash = primeNumber * hash + this.weight.hashCode();
        hash = primeNumber * hash + this.circumference.hashCode();
        return hash;
    }
}
