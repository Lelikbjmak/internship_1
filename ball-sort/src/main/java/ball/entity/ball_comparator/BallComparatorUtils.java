package ball.entity.ball_comparator;

import ball.entity.balls.Ball;

/**
 * Ball Comparator Utils - provides us with default business logic for
 * @see BallComparator
 */
public interface BallComparatorUtils {

    static int compareByWeightAsc(Ball o1, Ball o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }

    static int compareByCircumferenceAsc(Ball o1, Ball o2) {
        return o1.getCircumference().compareTo(o2.getCircumference());
    }

    static int compareByTypeAsc(Ball o1, Ball o2) {
        return o1.getType().name().compareTo(o2.getType().name());
    }

    static int compareByNameAsc(Ball o1, Ball o2) {
        return o1.getName().compareTo(o2.getName());
    }

    static int compareByColorAsc(Ball o1, Ball o2) {
        return o1.getColor().name().compareTo(o2.getColor().name());
    }

    static int compareByWeightDesc(Ball o1, Ball o2) {
        return o2.getWeight().compareTo(o1.getWeight());
    }

    static int compareByCircumferenceDesc(Ball o1, Ball o2) {
        return o2.getCircumference().compareTo(o1.getCircumference());
    }

    static int compareByTypeDesc(Ball o1, Ball o2) {
        return o2.getType().name().compareTo(o1.getType().name());
    }

    static int compareByNameDesc(Ball o1, Ball o2) {
        return o2.getName().compareTo(o1.getName());
    }

    static int compareByColorDesc(Ball o1, Ball o2) {
        return o2.getColor().name().compareTo(o1.getColor().name());
    }

}
