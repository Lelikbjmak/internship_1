package com.innowise.ball_factory.oddeven;

import com.innowise.ball_factory.builder.BallComparatorBuilder;
import com.innowise.ball_factory.builder.ColorPriorityBuilder;
import com.innowise.ball_factory.builder.TypePriorityBuilder;
import com.innowise.ball_factory.entity.Ball;
import com.innowise.ball_factory.entity.ball_const_field_types.Color;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;
import com.innowise.ball_factory.service.SortingService;
import com.innowise.ball_factory.sorts.oddeven.OddEvenSort;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OddEvenSortCustomPriorityTest {

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
    @Order(value = 1)
    public void contextLoad() {
        Assertions.assertNotNull(BALLS);
        Assertions.assertNotNull(SortingService.class);
        Assertions.assertNotNull(OddEvenSort.class);
    }

    @Test
    @DisplayName("Sort by DARK_TO_LIGHT COLOR priority")
    public void darkToLightColorPrioritySort() {

        Color firstColor = Color.BLACK;
        Color lastColor = Color.WHITE;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().colorPriorityComparator(true));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after DARK_TO_LIGHT color sort.");

        Assertions.assertEquals(lastColor, BALLS.get(BALLS.size() - 1).getColor(),
                "First color after DARK_TO_LIGHT color sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getAscPriorityMap()),
                "Color is not sorted according to DARK_TO_LIGHT color priority map");
    }

    @Test
    @DisplayName("Sort by LIGHT_TO_DARK COLOR priority")
    public void LightToDarkColorPrioritySort() {

        Color firstColor = Color.WHITE;
        Color lastColor = Color.BLACK;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().colorPriorityComparator(false));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after LIGHT_TO_DARK COLOR sort.");

        Assertions.assertEquals(lastColor, BALLS.get(BALLS.size() - 1).getColor(),
                "First color after LIGHT_TO_DARK COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getDescPriorityMap()),
                "Color is not sorted according to DARK_TO_LIGHT color priority map");
    }

    @Test
    @DisplayName("Sort by CUSTOM COLOR priority (BLACK = 1," +
            "RED = 2, PINK = 3)")
    public void customColorPrioritySortOne() {

        Map<Color, Integer> colorPriorityMap = Map.of(
                Color.BLACK, 1,
                Color.RED, 2,
                Color.PINK, 3
        );

        Color firstColor = Color.BLACK;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().colorPriorityComparator(colorPriorityMap));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after CUSTOM COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getCustomPriorityMap(colorPriorityMap)),
                "Color is not sorted according to DARK_TO_LIGHT COLOR priority map");
    }

    @Test
    @DisplayName("Sort by CUSTOM COLOR priority (WHITE = 1, RED = 2, PINK = 3," +
            "PURPLE = 4, ORANGE = 8, BLUE = 7)")
    public void customColorPrioritySortTwo() {

        Map<Color, Integer> colorPriorityMap = Map.of(
                Color.WHITE, 1,
                Color.RED, 2,
                Color.PINK, 3,
                Color.PURPLE, 4,
                Color.ORANGE, 8,
                Color.BLUE, 7
        );

        Color firstColor = Color.WHITE;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().colorPriorityComparator(colorPriorityMap));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after CUSTOM COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getCustomPriorityMap(colorPriorityMap)),
                "Color is not sorted according to CUSTOM COLOR priority map");
    }

    @Test
    @DisplayName("Sort by TO_SMALL_SPORT TYPE priority")
    public void toSmallSportTypePrioritySort() {

        Type firstType = Type.FOOTBALL;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().typePriorityComparator(false));

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First type after TO_SMALL_SPORT TYPE sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getDescPriorityMap()),
                "Type is not sorted according to TO_SMALL_SPORT TYPE priority map");
    }

    @Test
    @DisplayName("Sort by TO_LARGE_SPORT TYPE priority")
    public void toLargeSportTypePrioritySort() {

        Type firstType = Type.GOLF;

        SortingService<Ball> service = new SortingService<>();
        service.sort(new OddEvenSort<>(), BALLS,
                new BallComparatorBuilder().typePriorityComparator(true));

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First type after TO_LARGE_SPORT TYPE sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getAscPriorityMap()),
                "Type is not sorted according to TO_LARGE_SPORT TYPE priority map");
    }

    private static <T> boolean isPriorityArray(List<T> array, int n, Map<T, Integer> priority) {
        if (n == 1 || n == 0) return true;
        boolean compareResult = priority.get(array.get(n - 2))
                .compareTo(priority.get(array.get(n - 1))) < 1;
        return compareResult && isPriorityArray(array, n - 1, priority);
    }

}
