package ball.entity.ball_comparator;

import ball.entity.balls.Ball;

public interface BallComparatorUtils {

    static int compareByWeight(Ball o1, Ball o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }

    static int compareByCircumference(Ball o1, Ball o2) {
        return o1.getCircumference().compareTo(o2.getCircumference());
    }

    static int compareByType(Ball o1, Ball o2) {
        return o1.getType().name().compareTo(o2.getType().name());
    }

    static int compareByName(Ball o1, Ball o2) {
        return o1.getName().compareTo(o2.getName());
    }

    static int compareByColor(Ball o1, Ball o2) {
        return o1.getColor().name().compareTo(o2.getColor().name());
    }
}
