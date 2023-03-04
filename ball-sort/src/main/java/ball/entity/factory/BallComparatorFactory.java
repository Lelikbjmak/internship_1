package ball.entity.factory;

import ball.entity.ball_comparator.BallComparator;
import ball.entity.ball_comparator.BallComparatorUtils;
import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.function.Function;

/**
 * BillComparatorFactory - build a custom comparator to sort Basket with {@link Ball}
 */
public class BallComparatorFactory {

    /**
     * Build a custom single {@link BallComparator}
     *
     * @see Function
     */
    public static Function<ComparatorType, BallComparator> getBallComparator = (comparatorType) -> {

        switch (comparatorType) {
            case ASC_WEIGHT -> {
                return BallComparatorUtils::compareByWeightAsc;
            }
            case DESC_WEIGHT -> {
                return BallComparatorUtils::compareByWeightDesc;
            }
            case ASC_TYPE -> {
                return BallComparatorUtils::compareByTypeAsc;
            }
            case DESC_TYPE -> {
                return BallComparatorUtils::compareByTypeDesc;
            }
            case ASC_NAME -> {
                return BallComparatorUtils::compareByNameAsc;
            }
            case DESC_NAME -> {
                return BallComparatorUtils::compareByNameDesc;
            }
            case ASC_COLOR -> {
                return BallComparatorUtils::compareByColorAsc;
            }
            case DESC_COLOR -> {
                return BallComparatorUtils::compareByColorDesc;
            }
            case ASC_CIRCUMFERENCE -> {
                return BallComparatorUtils::compareByCircumferenceAsc;
            }
            case DESC_CIRCUMFERENCE -> {
                return BallComparatorUtils::compareByCircumferenceDesc;
            }
            default -> {
                return Ball::compareTo;
            }
        }
    };

    /**
     * @param comparatorTypes - attributes to sort {@link ComparatorType}
     * @method getBallComparatorChain - create a ComparatorChain
     */
    public static Comparator<Ball> getBallComparatorChain(ComparatorType... comparatorTypes) {

        if (comparatorTypes.length == 0) return Ball::compareTo;

        Comparator<Ball> ballComparatorChain = getBallComparator.apply(comparatorTypes[0]);

        for (int i = 1; i < comparatorTypes.length; i++) {
            ballComparatorChain = ballComparatorChain.thenComparing(getBallComparator.apply(comparatorTypes[i]));
        }

        return ballComparatorChain;
    }
}
