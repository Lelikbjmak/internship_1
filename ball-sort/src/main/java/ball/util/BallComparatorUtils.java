package ball.util;

import ball.entity.ball_comparator.BallComparator;
import ball.entity.balls.Ball;
import ball.entity.types.Color;
import ball.entity.types.Type;

import java.util.Map;

/**
 * Ball Comparator Utils - provides us with default business logic for
 *
 * @see BallComparator
 */
public class BallComparatorUtils {

    private BallComparatorUtils() {
        throw new IllegalArgumentException("Class " + this.getClass() + " is Util class.");
    }

    private static Map<Color, Integer> colorPriorityMap;

    private static Map<Type, Integer> typePriorityMap;

    public static int compareByWeightAsc(Ball o1, Ball o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }

    public static int compareByCircumferenceAsc(Ball o1, Ball o2) {
        return o1.getCircumference().compareTo(o2.getCircumference());
    }

    public static int compareByTypeAsc(Ball o1, Ball o2) {
        return o1.getType().name().compareTo(o2.getType().name());
    }

    public static int compareByNameAsc(Ball o1, Ball o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public static int compareByColorAsc(Ball o1, Ball o2) {
        return o1.getColor().name().compareTo(o2.getColor().name());
    }

    public static int compareByWeightDesc(Ball o1, Ball o2) {
        return o2.getWeight().compareTo(o1.getWeight());
    }

    public static int compareByCircumferenceDesc(Ball o1, Ball o2) {
        return o2.getCircumference().compareTo(o1.getCircumference());
    }

    public static int compareByTypeDesc(Ball o1, Ball o2) {
        return o2.getType().name().compareTo(o1.getType().name());
    }

    public static int compareByNameDesc(Ball o1, Ball o2) {
        return o2.getName().compareTo(o1.getName());
    }

    public static int compareByColorDesc(Ball o1, Ball o2) {
        return o2.getColor().name().compareTo(o1.getColor().name());
    }

    public static int compareByColorPriority(Ball o1, Ball o2) {
        Integer firstColorPriority = colorPriorityMap.get(o1.getColor());
        Integer secondColorPriority = colorPriorityMap.get(o2.getColor());
        return firstColorPriority.compareTo(secondColorPriority);
    }

    public static int compareByTypePriority(Ball o1, Ball o2) {
        Integer firstTypePriority = typePriorityMap.get(o1.getType());
        Integer secondTypePriority = typePriorityMap.get(o2.getType());
        return firstTypePriority.compareTo(secondTypePriority);
    }

    public static void setColorPriorityMap(Map<Color, Integer> colorPriorityMap) {
        BallComparatorUtils.colorPriorityMap = colorPriorityMap;
    }

    public static void setTypePriorityMap(Map<Type, Integer> typePriorityMap) {
        BallComparatorUtils.typePriorityMap = typePriorityMap;
    }
}
