package ball.heap;

import ball.entity.balls.*;
import ball.entity.types.Color;
import ball.entity.types.Type;
import ball.service.BallComparatorFactory;
import ball.service.SortingAlgorithm;
import ball.util.ColorPriorityBuilder;
import ball.util.TypePriorityBuilder;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HeapSortCustomPriorityTest {

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
    @Order(value = 1)
    public void contextLoad() {
        Assertions.assertNotNull(BALLS);
        Assertions.assertNotNull(SortingAlgorithm.class);
    }

    @Test
    @DisplayName("Sort by DARK_TO_LIGHT COLOR priority")
    public void darkToLightColorPrioritySort() {

        Color firstColor = Color.BLACK;
        Color lastColor = Color.WHITE;

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getDarkToLightColorPriorityBallComparator());

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after DARK_TO_LIGHT color sort.");

        Assertions.assertEquals(lastColor, BALLS.get(BALLS.size() - 1).getColor(),
                "First color after DARK_TO_LIGHT color sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getDarkToLightColorPriorityMap()),
                "Color is not sorted according to DARK_TO_LIGHT color priority map");
    }

    @Test
    @DisplayName("Sort by LIGHT_TO_DARK COLOR priority")
    public void LightToDarkColorPrioritySort() {

        Color firstColor = Color.WHITE;
        Color lastColor = Color.BLACK;

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getLightToDarkColorPriorityBallComparator());

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after LIGHT_TO_DARK COLOR sort.");

        Assertions.assertEquals(lastColor, BALLS.get(BALLS.size() - 1).getColor(),
                "First color after LIGHT_TO_DARK COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getLightToDarkColorPriorityMap()),
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

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getCustomColorPriorityBallComparator(colorPriorityMap));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after CUSTOM COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getCustomColorPriorityMap(colorPriorityMap)),
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

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getCustomColorPriorityBallComparator(colorPriorityMap));

        Assertions.assertEquals(firstColor, BALLS.get(0).getColor(),
                "First color after CUSTOM COLOR sort.");

        List<Color> colors = BALLS.stream()
                .map(Ball::getColor).toList();

        ColorPriorityBuilder builder = new ColorPriorityBuilder();
        Assertions.assertTrue(isPriorityArray(colors, colors.size(),
                        builder.getCustomColorPriorityMap(colorPriorityMap)),
                "Color is not sorted according to CUSTOM COLOR priority map");
    }

    @Test
    @DisplayName("Sort by TO_SMALL_SPORT TYPE priority")
    public void toSmallSportTypePrioritySort() {

        Type firstType = Type.FOOTBALL;

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getToSmallSportTypePriorityBallComparator());

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First type after TO_SMALL_SPORT TYPE sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getTypePriorityMapBySportScaleDesc()),
                "Type is not sorted according to TO_SMALL_SPORT TYPE priority map");
    }

    @Test
    @DisplayName("Sort by TO_LARGE_SPORT TYPE priority")
    public void toLargeSportTypePrioritySort() {

        Type firstType = Type.GOLF;

        SortingAlgorithm.heapSort(BALLS,
                BallComparatorFactory.getToLargeSportTypePriorityBallComparator());

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First type after TO_LARGE_SPORT TYPE sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getTypePriorityMapBySportScaleAsc()),
                "Type is not sorted according to TO_LARGE_SPORT TYPE priority map");
    }


    private static <T> boolean isPriorityArray(List<T> array, int n, Map<T, Integer> priority) {
        if (n == 1 || n == 0) return true;
        boolean compareResult = priority.get(array.get(n - 2))
                .compareTo(priority.get(array.get(n - 1))) < 1;
        return compareResult && isPriorityArray(array, n - 1, priority);
    }
}
