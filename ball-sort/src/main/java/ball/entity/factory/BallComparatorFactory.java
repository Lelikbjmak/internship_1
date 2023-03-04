package ball.entity.factory;

import ball.entity.ball_comparator.BallComparator;
import ball.entity.ball_comparator.BallComparatorUtils;
import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.Ball;

import java.util.Comparator;
import java.util.function.Function;

public class BallComparatorFactory {

    public static Function<ComparatorType, BallComparator> getBallComparator = (comparatorType) -> {

        switch (comparatorType) {
            case WEIGHT -> {
                return BallComparatorUtils::compareByWeight;
            }
            case TYPE -> {
                return BallComparatorUtils::compareByType;
            }
            case NAME -> {
                return BallComparatorUtils::compareByName;
            }
            case COLOR -> {
                return BallComparatorUtils::compareByColor;
            }
            case CIRCUMFERENCE -> {
                return BallComparatorUtils::compareByCircumference;
            }
            default -> {
                return Ball::compareTo;
            }
        }
    };

    public static BallComparator getBallComparatorChain(ComparatorType... comparatorTypes) {

        if (comparatorTypes.length == 0)
            return Ball::compareTo;

        BallComparator ballComparatorChain = getBallComparator.apply(comparatorTypes[0]);

        for (int i = 1; i < comparatorTypes.length; i++) {
            ballComparatorChain = (BallComparator) ballComparatorChain.thenComparing(getBallComparator.apply(comparatorTypes[i]));
        }

        return ballComparatorChain;
    }
}
