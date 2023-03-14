package com.innowise.ball_factory.oddeven;

import com.innowise.ball_factory.builder.BallComparatorBuilder;
import com.innowise.ball_factory.entity.Ball;
import com.innowise.ball_factory.entity.ball_const_field_types.Color;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;
import com.innowise.ball_factory.service.SortingService;
import com.innowise.ball_factory.sorts.merge.MergeSort;
import com.innowise.ball_factory.sorts.oddeven.OddEvenSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddEvenSortSingleAttributeTest {
    private static final List<Ball> BALLS = new ArrayList<>(List.of(

            new Ball("AX-197", 15.5, 123.00, Color.PURPLE, Type.BASEBALL),
            new Ball("AX-192", 15.5, 98.99, Color.PINK, Type.BASEBALL),
            new Ball("SX-193", 2.5, 106.62, Color.ORANGE, Type.BASEBALL),
            new Ball("jhsac", 7.65, 77.99, Color.WHITE, Type.BASEBALL),
            new Ball("VM-205", 5.5, 99.0, Color.PINK, Type.BASEBALL),
            new Ball("VM-203", 9.90, 109.0, Color.PINK, Type.BASEBALL),
            new Ball("AM-204", 86.5, 120.0, Color.RED, Type.BASEBALL),

            new Ball("ZX-198", 25.5, 949.00, Color.BLACK, Type.FOOTBALL),
            new Ball("CM-202", 25.5, 887.0, Color.WHITE, Type.FOOTBALL),
            new Ball("WX-195", 5.5, 776.12, Color.YELLOW, Type.FOOTBALL),
            new Ball("BM-203", 35.5, 1099.99, Color.BROWN, Type.FOOTBALL),
            new Ball("Zoom-X", 29.9, 887.88, Color.BLACK, Type.FOOTBALL),
            new Ball("Torsion", 77.2, 917.88, Color.BLUE, Type.FOOTBALL),
            new Ball("Telstar", 12.13, 927.88, Color.WHITE, Type.FOOTBALL),
            new Ball("Kuojin", 98.4, 999.99, Color.WHITE, Type.FOOTBALL),

            new Ball("Ambcs-190", 35.5, 1349.00, Color.GREY, Type.BASKETBALL),
            new Ball("Aa", 745.5, 1450.90, Color.GREEN, Type.BASKETBALL),
            new Ball("kN-192", 87.2, 88.23, Color.GREEN, Type.BASKETBALL),
            new Ball("Kx-10", 19.0, 28239.2, Color.ORANGE, Type.BASKETBALL),
            new Ball("Lkhs", 74.5, 76.2, Color.WHITE, Type.BASKETBALL),
            new Ball("bcas", 45.5, 998.2, Color.GREY, Type.BASKETBALL),
            new Ball("Zz", 91.2, 14502.90, Color.PURPLE, Type.BASKETBALL),

            new Ball("Scks-892", 10.29, 643.2, Color.BLACK, Type.WATER_POLO),
            new Ball("Lnvs", 2.20, 9, Color.PURPLE, Type.WATER_POLO),
            new Ball("La-18", 98.2, 1, Color.PINK, Type.WATER_POLO),
            new Ball("Fifa", 1090.90, 763, Color.BLUE, Type.WATER_POLO),
            new Ball("Khfua", 98.99, 643.87, Color.GREEN, Type.WATER_POLO),
            new Ball("Jhs", 98.99, 73.2, Color.GREEN, Type.WATER_POLO),
            new Ball("Plos", 98.99, 643.87, Color.GREEN, Type.WATER_POLO),

            new Ball("Aaams", 98.99, 13.87, Color.BLACK, Type.HANDBALL),
            new Ball("Bcks", 77.23, 666.34, Color.BLUE, Type.HANDBALL),
            new Ball("Pljs", 91.12, 95.87, Color.RED, Type.HANDBALL),
            new Ball("Zxv", 91.12, 63.87, Color.PINK, Type.HANDBALL),
            new Ball("Jfa", 65.2, 645.90, Color.PURPLE, Type.HANDBALL),
            new Ball("Aaz", 87.223, 43.87, Color.GREEN, Type.HANDBALL),

            new Ball("Aac", 87.23, 403.87, Color.BLACK, Type.VOLLEYBALL),
            new Ball("Aan", 81.223, 431.87, Color.GREY, Type.VOLLEYBALL),
            new Ball("Aak", 80.223, 433.87, Color.GREEN, Type.VOLLEYBALL),
            new Ball("Aaz", 76.9, 34.34, Color.BLACK, Type.VOLLEYBALL),
            new Ball("Baz", 990, 77.878, Color.BLACK, Type.VOLLEYBALL),
            new Ball("Bam", 45.45, 87.8, Color.BROWN, Type.VOLLEYBALL),
            new Ball("Ljhgd", 12.12, 43.87, Color.GREEN, Type.VOLLEYBALL),

            new Ball("Naz", 887.03, 13.87, Color.PINK, Type.SOCCER),
            new Ball("Zaz-90", 89.13, 23.97, Color.YELLOW, Type.SOCCER),
            new Ball("Aaz", 12.93, 56.17, Color.GREY, Type.SOCCER),
            new Ball("jaz", 17.73, 433.27, Color.WHITE, Type.SOCCER),
            new Ball("aaz", 27.3, 60.37, Color.GREEN, Type.SOCCER),
            new Ball("jaz", 76.5, 93.87, Color.BLUE, Type.SOCCER),

            new Ball("aaa", 647.293, 723.97, Color.YELLOW, Type.TENNIS),
            new Ball("bbb", 187.21, 123.27, Color.WHITE, Type.TENNIS),
            new Ball("zzz", 7.93, 93.18, Color.GREEN, Type.TENNIS),
            new Ball("Khsd", 9.03, 73.657, Color.WHITE, Type.TENNIS),
            new Ball("Plhbd", 27.23, 473.31, Color.GREEN, Type.TENNIS),
            new Ball("ans", 87.223, 53.17, Color.YELLOW, Type.TENNIS),

            new Ball("Ljsda", 7.3, 23.23, Color.PINK, Type.GOLF),
            new Ball("cs", 813.0, 43.2387, Color.GREEN, Type.GOLF),
            new Ball("pol", 91.92, 987.23, Color.PINK, Type.GOLF),
            new Ball("kjd", 77.77, 77.21, Color.GREEN, Type.GOLF),
            new Ball("jnds", 66.66, 54.634, Color.WHITE, Type.GOLF),
            new Ball("kgs", 12.203, 9.92, Color.BLACK, Type.GOLF),
            new Ball("lls", 89.03, 42.20, Color.YELLOW, Type.GOLF)
    ));

    @BeforeEach
    public void shuffleList() {
        Collections.shuffle(BALLS);
    }

    @Test
    public void contextLoad() {
        Assertions.assertNotNull(BALLS);
        Assertions.assertNotNull(SortingService.class);
        Assertions.assertNotNull(MergeSort.class);
    }

    @Test
    @DisplayName(value = "Sort by NAME (asc)")
    public void ascSortByName() {

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().nameComparator());

        Ball first = new Ball("AM-204", 86.5, 120.0, Color.RED, Type.BASEBALL);
        Ball last = new Ball("zzz", 7.93, 93.18, Color.GREEN, Type.TENNIS);

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'NAME' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'NAME' attribute.");

        List<String> ballNames = BALLS.stream()
                .map(Ball::getName).toList();

        Assertions.assertTrue(isAscArray(ballNames, ballNames.size()));
    }

    @Test
    @DisplayName(value = "Sort by NAME (desc)")
    public void descSortByName() {

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().nameComparator().reversed());

        Ball last = new Ball("AM-204", 86.5, 120.0, Color.RED, Type.BASEBALL);
        Ball first = new Ball("zzz", 7.93, 93.18, Color.GREEN, Type.TENNIS);

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'NAME' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'NAME' attribute.");

        List<String> ballNames = BALLS.stream()
                .map(Ball::getName).toList();

        Assertions.assertTrue(isDescArray(ballNames, ballNames.size()));
    }

    @Test
    @DisplayName(value = "Sort by WEIGHT (asc)")
    public void ascSortByWeight() {

        Ball first = new Ball("La-18", 98.2, 1, Color.PINK, Type.WATER_POLO);
        Ball last = new Ball("Kx-10", 19.0, 28239.2, Color.ORANGE, Type.BASKETBALL);

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().weightComparator());

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'WEIGHT' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'WEIGHT' attribute.");

        double[] ballsWeight = BALLS.stream().mapToDouble(Ball::getWeight).toArray();
        Assertions.assertTrue(isAscArray(ballsWeight, ballsWeight.length));
    }

    @Test
    @DisplayName(value = "Sort by WEIGHT (desc)")
    public void descSortByWeight() {

        Ball last = new Ball("La-18", 98.2, 1, Color.PINK, Type.WATER_POLO);
        Ball first = new Ball("Kx-10", 19.0, 28239.2, Color.ORANGE, Type.BASKETBALL);

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().weightComparator().reversed());

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

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().colorComparator());

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

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().colorComparator().reversed());

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

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().typeComparator());

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

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().typeComparator().reversed());

        Assertions.assertEquals(first, BALLS.get(0).getType(), "Incorrect first element after sort by 'TYPE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(), "Incorrect last element after sort by 'TYPE' attribute.");

        List<String> ballTypes = BALLS.stream()
                .map(ball -> ball.getType().name()).toList();

        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()));
    }

    @Test
    @DisplayName(value = "Sort by CIRCUMFERENCE (asc)")
    public void ascSortByCircumference() {

        Ball first = new Ball("Lnvs", 2.20, 9, Color.PURPLE, Type.WATER_POLO);
        Ball last = new Ball("Fifa", 1090.90, 763, Color.BLUE, Type.WATER_POLO);

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().circumferenceComparator());

        Assertions.assertEquals(first, BALLS.get(0), "Incorrect first element after sort by 'CIRCUMFERENCE' attribute.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1), "Incorrect last element after sort by 'CIRCUMFERENCE' attribute.");

        double[] ballsCircumferences = BALLS.stream().mapToDouble(Ball::getCircumference).toArray();
        Assertions.assertTrue(isAscArray(ballsCircumferences, ballsCircumferences.length));
    }

    @Test
    @DisplayName(value = "Sort by CIRCUMFERENCE (desc)")
    public void descSortByCircumference() {

        Ball last = new Ball("Lnvs", 2.20, 9, Color.PURPLE, Type.WATER_POLO);
        Ball first = new Ball("Fifa", 1090.90, 763, Color.BLUE, Type.WATER_POLO);

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS, new BallComparatorBuilder().circumferenceComparator().reversed());

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


