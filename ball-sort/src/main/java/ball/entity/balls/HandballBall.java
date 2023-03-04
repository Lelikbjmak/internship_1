package ball.entity.balls;

import ball.entity.types.Color;
import ball.entity.types.Type;

/**
 * Implementation of {@link Ball}
 */
public class HandballBall extends Ball {

    public HandballBall(String name, double circumference,
                        double weight, Color color) {

        super(Type.HANDBALL);
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
