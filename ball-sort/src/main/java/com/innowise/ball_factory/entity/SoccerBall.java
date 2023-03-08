package com.innowise.ball_factory.entity;

import com.innowise.ball_factory.entity.ball_const_field_types.Color;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;

/**
 * Implementation of {@link Ball}
 */
public class SoccerBall extends Ball {

    public SoccerBall(String name, double circumference,
                      double weight, Color color) {

        super(Type.SOCCER);
        this.name = name;
        this.circumference = circumference;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nType: " + type.name() + "\nColor: "
                + color.name() + "\nWeight: " + weight + "\nCircumference: " + circumference;
    }
}
