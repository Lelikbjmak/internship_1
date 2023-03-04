package ball.entity.ball_comparator;

/**
 * @see java.lang.Enum
 * Contributes to build custom {@link BallComparator},
 * particularly business logic of sort alorithm (asc/desc).
 * Choose sorting attributes.
 */
public enum ComparatorType {
    ASC_NAME,
    DESC_NAME,
    ASC_WEIGHT,
    DESC_WEIGHT,
    ASC_COLOR,
    DESC_COLOR,
    ASC_TYPE,
    DESC_TYPE,
    ASC_CIRCUMFERENCE,
    DESC_CIRCUMFERENCE
}
