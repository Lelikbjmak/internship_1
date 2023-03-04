package ball;

import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.Ball;
import ball.entity.balls.BaseballBall;
import ball.entity.balls.BasketballBall;
import ball.entity.balls.FootballBall;
import ball.entity.factory.BallComparatorFactory;
import ball.entity.types.Color;
import ball.entity.types.Type;
import ball.sorts.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuickSortTest {

    // TODO: Make List of Balls bigger -> leverage all types of Balls. Test several attribute sorting
    // TODO: Test QuickSort with several attributes
    private static final List<Ball> BALLS = new ArrayList<>(List.of(

            new BaseballBall("AX-197", 15.5, 123.00, Color.PURPLE),
            new BaseballBall("SX-193", 2.5, 106.62, Color.ORANGE),
            new BaseballBall("VM-205", 5.5, 99.0, Color.PINK),
            new FootballBall("ZX-198", 25.5, 949.00, Color.BLACK),
            new FootballBall("CM-202", 25.5, 887.0, Color.WHITE),
            new BaseballBall("AM-204", 86.5, 120.0, Color.RED),
            new FootballBall("BM-203", 35.5, 699.99, Color.BROWN),
            new BasketballBall("FX-190", 35.5, 1349.00, Color.GREY),
            new BasketballBall("KX-192", 745.5, 1450.90, Color.GREEN),
            new FootballBall("WX-195", 5.5, 776.12, Color.YELLOW)
    ));

    @BeforeEach
    public void shuffleList() {
        Collections.shuffle(BALLS);
    }

    @Test
    @DisplayName(value = "Sort by NAME (asc)")
    public void ascSortByName() {

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_NAME));
        Ball first = new BaseballBall("AM-204", 86.5, 120.0, Color.RED);
        Ball last = new FootballBall("ZX-198", 25.5, 949.00, Color.BLACK);
        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'NAME' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'NAME' attribute.");
    }

    @Test
    @DisplayName(value = "Sort by WEIGHT (asc)")
    public void ascSortByWeight() {

        Ball first = new BaseballBall("VM-205", 5.5, 99.0, Color.PINK);
        Ball last = new BasketballBall("KX-192", 745.5, 1450.90, Color.GREEN);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_WEIGHT));
        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'WEIGHT' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'WEIGHT' attribute.");
    }

    @Test
    @DisplayName(value = "Sort by COLOR (asc)")
    public void ascSortByColor() {

        Ball first = new FootballBall("ZX-198", 25.5, 949.00, Color.BLACK);
        Ball last = new FootballBall("WX-195", 5.5, 776.12, Color.YELLOW);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_COLOR));
        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'COLOR' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'COLOR' attribute.");
    }

    @Test
    @DisplayName(value = "Sort by TYPE (asc)")
    public void ascSortByType() {

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_TYPE));
        Assertions.assertEquals(Type.BASEBALL, BALLS.get(0).getType(), "Incorrect first element after sort by 'TYPE' attribute.");
        Assertions.assertEquals(Type.FOOTBALL, BALLS.get(BALLS.size() - 1).getType(), "Incorrect last element after sort by 'TYPE' attribute.");
    }

    @Test
    @DisplayName(value = "Sort by CIRCUMFERENCE (asc)")
    public void ascSortByCircumference() {

        Ball first = new BaseballBall("SX-193", 2.5, 106.62, Color.ORANGE);
        Ball last = new BasketballBall("KX-192", 745.5, 1450.90, Color.GREEN);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_CIRCUMFERENCE));
        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'CIRCUMFERENCE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'CIRCUMFERENCE' attribute.");
    }
}
