package ball;

import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.*;
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


public class QuickSortSingleAttributeTest {

    private static final List<Ball> BALLS = new ArrayList<>(List.of(

            new BaseballBall("AX-197", 15.5, 123.00, Color.PURPLE),
            new BaseballBall("AX-192", 15.5, 98.99, Color.PINK),
            new BaseballBall("SX-193", 2.5, 106.62, Color.ORANGE),
            new BaseballBall("jhsac", 7.65, 77.99, Color.WHITE),
            new BaseballBall("VM-205", 5.5, 99.0, Color.PINK),
            new BaseballBall("VM-203", 9.90, 109.0, Color.PINK),
            new BaseballBall("AM-204", 86.5, 120.0, Color.RED),

            new FootballBall("ZX-198", 25.5, 949.00, Color.BLACK),
            new FootballBall("CM-202", 25.5, 887.0, Color.WHITE),
            new FootballBall("WX-195", 5.5, 776.12, Color.YELLOW),
            new FootballBall("BM-203", 35.5, 1099.99, Color.BROWN),
            new FootballBall("Zoom-X", 29.9, 887.88, Color.BLACK),
            new FootballBall("Torsion", 77.2, 917.88, Color.BLUE),
            new FootballBall("Telstar", 12.13, 927.88, Color.WHITE),
            new FootballBall("Kuojin", 98.4, 999.99, Color.WHITE),

            new BasketballBall("Ambcs-190", 35.5, 1349.00, Color.GREY),
            new BasketballBall("Aa", 745.5, 1450.90, Color.GREEN),
            new BasketballBall("kN-192", 87.2, 88.23, Color.GREEN),
            new BasketballBall("Kx-10", 19.0, 28239.2, Color.ORANGE),
            new BasketballBall("Lkhs", 74.5, 76.2, Color.WHITE),
            new BasketballBall("bcas", 45.5, 998.2, Color.GREY),
            new BasketballBall("Zz", 91.2, 14502.90, Color.PURPLE),

            new WaterPoloBall("Scks-892", 10.29, 643.2, Color.BLACK),
            new WaterPoloBall("Lnvs", 2.20, 9, Color.PURPLE),
            new WaterPoloBall("La-18", 98.2, 1, Color.PINK),
            new WaterPoloBall("Fifa", 1090.90, 763, Color.BLUE),
            new WaterPoloBall("Khfua", 98.99, 643.87, Color.GREEN),
            new WaterPoloBall("Jhs", 98.99, 73.2, Color.GREEN),
            new WaterPoloBall("Plos", 98.99, 643.87, Color.GREEN),

            new HandballBall("Aaams", 98.99, 13.87, Color.BLACK),
            new HandballBall("Bcks", 77.23, 666.34, Color.BLUE),
            new HandballBall("Pljs", 91.12, 95.87, Color.RED),
            new HandballBall("Zxv", 91.12, 63.87, Color.PINK),
            new HandballBall("Jfa", 65.2, 645.90, Color.PURPLE),
            new HandballBall("Aaz", 87.223, 43.87, Color.GREEN),

            new VolleyballBall("Aac", 87.23, 403.87, Color.BLACK),
            new VolleyballBall("Aan", 81.223, 431.87, Color.GREY),
            new VolleyballBall("Aak", 80.223, 433.87, Color.GREEN),
            new VolleyballBall("Aaz", 76.9, 34.34, Color.BLACK),
            new VolleyballBall("Baz", 990, 77.878, Color.BLACK),
            new VolleyballBall("Bam", 45.45, 87.8, Color.BROWN),
            new VolleyballBall("Ljhgd", 12.12, 43.87, Color.GREEN),

            new SoccerBall("Naz", 887.03, 13.87, Color.PINK),
            new SoccerBall("Zaz-90", 89.13, 23.97, Color.YELLOW),
            new SoccerBall("Aaz", 12.93, 56.17, Color.GREY),
            new SoccerBall("jaz", 17.73, 433.27, Color.WHITE),
            new SoccerBall("aaz", 27.3, 60.37, Color.GREEN),
            new SoccerBall("jaz", 76.5, 93.87, Color.BLUE),

            new TennisBall("aaa", 647.293, 723.97, Color.YELLOW),
            new TennisBall("bbb", 187.21, 123.27, Color.WHITE),
            new TennisBall("zzz", 7.93, 93.18, Color.GREEN),
            new TennisBall("Khsd", 9.03, 73.657, Color.WHITE),
            new TennisBall("Plhbd", 27.23, 473.31, Color.GREEN),
            new TennisBall("ans", 87.223, 53.17, Color.YELLOW),

            new GolfBall("Ljsda", 7.3, 23.23, Color.PINK),
            new GolfBall("cs", 813.0, 43.2387, Color.GREEN),
            new GolfBall("pol", 91.92, 987.23, Color.PINK),
            new GolfBall("kjd", 77.77, 77.21, Color.GREEN),
            new GolfBall("jnds", 66.66, 54.634, Color.WHITE),
            new GolfBall("kgs", 12.203, 9.92, Color.BLACK),
            new GolfBall("lls", 89.03, 42.20, Color.YELLOW)
    ));

    @BeforeEach
    public void shuffleList() {
        Collections.shuffle(BALLS);
    }

    @Test
    public void contextLoad() {
        Assertions.assertNotNull(BALLS);
        Assertions.assertNotNull(QuickSort.class);
    }

    @Test
    @DisplayName(value = "Sort by NAME (asc)")
    public void ascSortByName() {

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_NAME));
        Ball first = new BaseballBall("AM-204", 86.5, 120.0, Color.RED);
        Ball last = new TennisBall("zzz", 7.93, 93.18, Color.GREEN);

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'NAME' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'NAME' attribute.");

        List<String> ballNames = BALLS.stream()
                .map(Ball::getName).toList();

        Assertions.assertTrue(isAscArray(ballNames, ballNames.size()));
    }

    @Test
    @DisplayName(value = "Sort by NAME (desc)")
    public void descSortByName() {

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.DESC_NAME));
        Ball last = new BaseballBall("AM-204", 86.5, 120.0, Color.RED);
        Ball first = new TennisBall("zzz", 7.93, 93.18, Color.GREEN);

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'NAME' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'NAME' attribute.");

        List<String> ballNames = BALLS.stream()
                .map(Ball::getName).toList();

        Assertions.assertTrue(isDescArray(ballNames, ballNames.size()));
    }

    @Test
    @DisplayName(value = "Sort by WEIGHT (asc)")
    public void ascSortByWeight() {

        Ball first = new WaterPoloBall("La-18", 98.2, 1, Color.PINK);
        Ball last = new BasketballBall("Kx-10", 19.0, 28239.2, Color.ORANGE);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'WEIGHT' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'WEIGHT' attribute.");

        double[] ballsWeight = BALLS.stream().mapToDouble(Ball::getWeight).toArray();
        Assertions.assertTrue(isAscArray(ballsWeight, ballsWeight.length));
    }

    @Test
    @DisplayName(value = "Sort by WEIGHT (desc)")
    public void descSortByWeight() {

        Ball last = new WaterPoloBall("La-18", 98.2, 1, Color.PINK);
        Ball first = new BasketballBall("Kx-10", 19.0, 28239.2, Color.ORANGE);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'WEIGHT' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'WEIGHT' attribute.");

        double[] ballsWeight = BALLS.stream().mapToDouble(Ball::getWeight).toArray();
        Assertions.assertTrue(isDescArray(ballsWeight, ballsWeight.length));
    }

    /**
     * Due to the fact that we shuffle our List before each test
     * hence it's mad hard to anticipate a certain Ball as 'first' and 'last' elements after sort
     * that's why we compare only colors.
     */
    @Test
    @DisplayName(value = "Sort by COLOR (asc)")
    public void ascSortByColor() {

        Color first = Color.BLACK;
        Color last = Color.YELLOW;

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_COLOR));

        Assertions.assertEquals(first, BALLS.get(0).getColor(), "Incorrect first element after sort by 'COLOR' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(), "Incorrect last element after sort by 'COLOR' attribute.");

        List<String> ballColors = BALLS.stream()
                .map(ball -> ball.getColor().name()).toList();

        Assertions.assertTrue(isAscArray(ballColors, ballColors.size()));

    }

    /**
     * Due to the fact that we shuffle our List before each test
     * hence it's mad hard to anticipate a certain Ball as 'first' and 'last' elements after sort
     * that's why we compare only colors.
     */
    @Test
    @DisplayName(value = "Sort by COLOR (desc)")
    public void descSortByColor() {

        Color last = Color.BLACK;
        Color first = Color.YELLOW;

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.DESC_COLOR));

        Assertions.assertEquals(first, BALLS.get(0).getColor(), "Incorrect first element after sort by 'COLOR' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(), "Incorrect last element after sort by 'COLOR' attribute.");

        List<String> ballColors = BALLS.stream()
                .map(ball -> ball.getColor().name()).toList();

        Assertions.assertTrue(isDescArray(ballColors, ballColors.size()));
    }

    /**
     * Due to the fact that we shuffle our List before each test
     * hence it's mad hard to anticipate a certain Ball as 'first' and 'last' elements after sort
     * that's why we compare only Type of balls.
     */
    @Test
    @DisplayName(value = "Sort by TYPE (asc)")
    public void ascSortByType() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_TYPE));

        Assertions.assertEquals(first, BALLS.get(0).getType(), "Incorrect first element after sort by 'TYPE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(), "Incorrect last element after sort by 'TYPE' attribute.");

        List<String> ballTypes = BALLS.stream()
                .map(ball -> ball.getType().name()).toList();

        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()));
    }

    /**
     * Due to the fact that we shuffle our List before each test
     * hence it's mad hard to anticipate a certain Ball as 'first' and 'last' elements after sort
     * that's why we compare only Type of balls.
     */
    @Test
    @DisplayName(value = "Sort by TYPE (desc)")
    public void descSortByType() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.DESC_TYPE));

        Assertions.assertEquals(first, BALLS.get(0).getType(), "Incorrect first element after sort by 'TYPE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(), "Incorrect last element after sort by 'TYPE' attribute.");

        List<String> ballTypes = BALLS.stream()
                .map(ball -> ball.getType().name()).toList();

        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()));
    }

    @Test
    @DisplayName(value = "Sort by CIRCUMFERENCE (asc)")
    public void ascSortByCircumference() {

        Ball first = new WaterPoloBall("Lnvs", 2.20, 9, Color.PURPLE);
        Ball last = new WaterPoloBall("Fifa", 1090.90, 763, Color.BLUE);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'CIRCUMFERENCE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'CIRCUMFERENCE' attribute.");

        double[] ballsCircumferences = BALLS.stream().mapToDouble(Ball::getCircumference).toArray();
        Assertions.assertTrue(isAscArray(ballsCircumferences, ballsCircumferences.length));
    }

    @Test
    @DisplayName(value = "Sort by CIRCUMFERENCE (desc)")
    public void descSortByCircumference() {

        Ball last = new WaterPoloBall("Lnvs", 2.20, 9, Color.PURPLE);
        Ball first = new WaterPoloBall("Fifa", 1090.90, 763, Color.BLUE);

        QuickSort.sort(BALLS, BallComparatorFactory.getBallComparator.apply(ComparatorType.DESC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'CIRCUMFERENCE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'CIRCUMFERENCE' attribute.");

        double[] ballsCircumferences = BALLS.stream().mapToDouble(Ball::getCircumference).toArray();
        Assertions.assertTrue(isDescArray(ballsCircumferences, ballsCircumferences.length));
    }

    private static boolean isAscArray(double[] array, int n) {
        if (n == 1 || n == 0) return true;
        return array[n - 2] <= array[n - 1] && isAscArray(array, n - 1);
    }

    private static boolean isDescArray(double[] array, int n) {
        if (n == 1 || n == 0) return true;
        return array[n - 2] >= array[n - 1] && isDescArray(array, n - 1);
    }

    private static boolean isAscArray(List<String> array, int n) {
        if (n == 1 || n == 0) return true;
        boolean compareResult = array.get(n - 2).compareTo(array.get(n - 1)) < 1;
        return compareResult && isAscArray(array, n - 1);
    }

    private static boolean isDescArray(List<String> array, int n) {
        if (n == 1 || n == 0) return true;
        boolean compareResult = array.get(n - 2).compareTo(array.get(n - 1)) > -1;
        return compareResult && isDescArray(array, n - 1);
    }
}
