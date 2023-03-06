package ball.quick;

import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.*;
import ball.entity.types.Color;
import ball.entity.types.Type;
import ball.service.BallComparatorFactory;
import ball.service.SortingAlgorithm;
import ball.util.ColorPriorityBuilder;
import ball.util.TypePriorityBuilder;
import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QuickSortSeveralAttributesTest {

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
    @DisplayName("Sort by NAME(asc), WEIGHT(asc)")
    public void ascNameAscWeightSort() {

        String firstName = "AM-204";
        String lastName = "zzz";

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_NAME, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(0, firstName.compareTo(BALLS.get(0).getName()),
                "Name of first element doesn't match after NAME(asc), WEIGHT(asc) sort.");
        Assertions.assertEquals(0, lastName.compareTo(BALLS.get(BALLS.size() - 1).getName()),
                "Name of last element doesn't match after NAME(asc), WEIGHT(asc) sort.");

        List<String> ballNames = BALLS.stream().map((Ball::getName)).toList();
        Assertions.assertTrue(isAscArray(ballNames, ballNames.size()),
                "Attribute NAME isn't sorted (asc).");

        Map<String, double[]> ballsWeight = new HashMap<>();
        for (String name :
                ballNames) {
            ballsWeight.put(name, BALLS.stream()
                    .filter(ball -> ball.getName().equals(name))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((name, ballsWeightPerType) ->
                Assertions.assertTrue(isAscArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (asc) for NAME: " + name + "."));
    }

    @Test
    @DisplayName("Sort by NAME(desc), WEIGHT(asc)")
    public void descNameAscWeightSort() {

        String lastName = "AM-204";
        String firstName = "zzz";

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_NAME, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(0, firstName.compareTo(BALLS.get(0).getName()),
                "Name of first element doesn't match after NAME(desc), WEIGHT(asc) sort.");
        Assertions.assertEquals(0, lastName.compareTo(BALLS.get(BALLS.size() - 1).getName()),
                "Name of last element doesn't match after NAME(desc), WEIGHT(asc) sort.");

        List<String> ballNames = BALLS.stream().map((Ball::getName)).toList();
        Assertions.assertTrue(isDescArray(ballNames, ballNames.size()),
                "Attribute NAME isn't sorted (desc).");

        Map<String, double[]> ballsWeight = new HashMap<>();
        for (String name :
                ballNames) {
            ballsWeight.put(name, BALLS.stream()
                    .filter(ball -> ball.getName().equals(name))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((name, ballsWeightPerType) ->
                Assertions.assertTrue(isAscArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (asc) for NAME: " + name + "."));
    }

    @Test
    @DisplayName("Sort by NAME(asc), WEIGHT(desc)")
    public void ascNameDescWeightSort() {

        String firstName = "AM-204";
        String lastName = "zzz";

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_NAME, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(0, firstName.compareTo(BALLS.get(0).getName()),
                "Name of first element doesn't match after NAME(asc), WEIGHT(desc) sort.");
        Assertions.assertEquals(0, lastName.compareTo(BALLS.get(BALLS.size() - 1).getName()),
                "Name of last element doesn't match after NAME(asc), WEIGHT(desc) sort.");

        List<String> ballNames = BALLS.stream().map((Ball::getName)).toList();
        Assertions.assertTrue(isAscArray(ballNames, ballNames.size()),
                "Attribute NAME isn't sorted (asc).");

        Map<String, double[]> ballsWeight = new HashMap<>();
        for (String name :
                ballNames) {
            ballsWeight.put(name, BALLS.stream()
                    .filter(ball -> ball.getName().equals(name))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((name, ballsWeightPerType) ->
                Assertions.assertTrue(isDescArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (desc) for NAME: " + name + "."));
    }

    @Test
    @DisplayName("Sort by NAME(desc), WEIGHT(desc)")
    public void descNameDescWeightSort() {

        String lastName = "AM-204";
        String firstName = "zzz";

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_NAME, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(0, firstName.compareTo(BALLS.get(0).getName()),
                "Name of first element doesn't match after NAME(desc), WEIGHT(desc) sort.");
        Assertions.assertEquals(0, lastName.compareTo(BALLS.get(BALLS.size() - 1).getName()),
                "Name of last element doesn't match after NAME(desc), WEIGHT(desc) sort.");

        List<String> ballNames = BALLS.stream().map((Ball::getName)).toList();
        Assertions.assertTrue(isDescArray(ballNames, ballNames.size()),
                "Attribute NAME isn't sorted (desc).");

        Map<String, double[]> ballsWeight = new HashMap<>();
        for (String name :
                ballNames) {
            ballsWeight.put(name, BALLS.stream()
                    .filter(ball -> ball.getName().equals(name))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((name, ballsWeightPerType) ->
                Assertions.assertTrue(isDescArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (desc) for NAME: " + name + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), WEIGHT(asc)")
    public void ascTypeAscWeightSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "Type of first element doesn't match after TYPE(asc), WEIGHT(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "Type of last element doesn't match after TYPE(asc), WEIGHT(asc) sort.");

        List<String> ballTypes = BALLS.stream().map((ball -> ball.getType().name())).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, double[]> ballsWeight = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsWeight.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((type, ballsWeightPerType) ->
                Assertions.assertTrue(isAscArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (asc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), WEIGHT(desc)")
    public void ascTypeDescWeightSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "Type of first element doesn't match after TYPE(asc), WEIGHT(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "Type of last element doesn't match after TYPE(asc), WEIGHT(desc) sort.");

        List<String> ballTypes = BALLS.stream().map((ball -> ball.getType().name())).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, double[]> ballsWeight = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsWeight.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((type, ballsWeightPerType) ->
                Assertions.assertTrue(isDescArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (desc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), WEIGHT(asc)")
    public void descTypeAscWeightSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "Type of first element doesn't match after TYPE(desc), WEIGHT(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "Type of last element doesn't match after TYPE(desc), WEIGHT(asc) sort.");

        List<String> ballTypes = BALLS.stream().map((ball -> ball.getType().name())).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, double[]> ballsWeight = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsWeight.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((type, ballsWeightPerType) ->
                Assertions.assertTrue(isAscArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (asc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), WEIGHT(desc)")
    public void descTypeDescWeightSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "The type of first element doesn't match after TYPE(desc), WEIGHT(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "The type of last element doesn't match after TYPE(desc), WEIGHT(desc) sort.");

        List<String> ballTypes = BALLS.stream().map((ball -> ball.getType().name())).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, double[]> ballsWeight = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsWeight.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .mapToDouble(Ball::getWeight)
                    .toArray());
        }

        ballsWeight.forEach((type, ballsWeightPerType) ->
                Assertions.assertTrue(isDescArray(ballsWeightPerType, ballsWeightPerType.length),
                        "Attribute WEIGHT isn't sorted (desc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by COLOR(asc), CIRCUMFERENCE(asc)")
    public void ascColorAscCircumferenceSort() {

        Color first = Color.BLACK;
        Color last = Color.YELLOW;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_COLOR, ComparatorType.ASC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0).getColor(),
                "First element color doesn't match after COLOR(asc), CIRCUMFERENCE(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(),
                "First element color doesn't match after COLOR(asc), CIRCUMFERENCE(asc) sort.");

        List<String> ballColors = BALLS.stream().map(ball -> ball.getColor().name()).toList();
        Assertions.assertTrue(isAscArray(ballColors, ballColors.size()),
                "Attribute COLOR isn't sorted (asc).");

        Map<Color, double[]> ballCircumferences = new HashMap<>();
        for (Color color :
                Color.values()) {
            ballCircumferences.put(color, BALLS.stream()
                    .filter(ball -> ball.getColor().equals(color))
                    .mapToDouble(Ball::getCircumference)
                    .toArray());
        }

        ballCircumferences.forEach((color, ballCircumferencesPerColor) ->
                Assertions.assertTrue(isAscArray(ballCircumferencesPerColor, ballCircumferencesPerColor.length),
                        "Attribute CIRCUMFERENCE isn't sorted (asc) for TYPE: " + color.name() + "."));
    }

    @Test
    @DisplayName("Sort by COLOR(asc), CIRCUMFERENCE(desc)")
    public void ascColorDescCircumferenceSort() {

        Color first = Color.BLACK;
        Color last = Color.YELLOW;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_COLOR, ComparatorType.DESC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0).getColor(),
                "First element color doesn't match after COLOR(asc), CIRCUMFERENCE(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(),
                "First element color doesn't match after COLOR(asc), CIRCUMFERENCE(desc) sort.");

        List<String> ballColors = BALLS.stream().map(ball -> ball.getColor().name()).toList();
        Assertions.assertTrue(isAscArray(ballColors, ballColors.size()),
                "Attribute COLOR isn't sorted (asc).");

        Map<Color, double[]> ballCircumferences = new HashMap<>();
        for (Color color :
                Color.values()) {

            ballCircumferences.put(color, BALLS.stream()
                    .filter(ball -> ball.getColor().equals(color))
                    .mapToDouble(Ball::getCircumference)
                    .toArray());
        }

        ballCircumferences.forEach((color, colorCircumferences) ->
                Assertions.assertTrue(isDescArray(colorCircumferences, colorCircumferences.length),
                        "Attribute CIRCUMFERENCE isn't sorted (desc) for color + " + color.name() + "."));

    }

    @Test
    @DisplayName("Sort by COLOR(desc), CIRCUMFERENCE(asc)")
    public void descColorAscCircumferenceSort() {

        Color first = Color.YELLOW;
        Color last = Color.BLACK;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_COLOR, ComparatorType.ASC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0).getColor(),
                "First element color doesn't match after COLOR(desc), CIRCUMFERENCE(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(),
                "First element color doesn't match after COLOR(desc), CIRCUMFERENCE(asc) sort.");

        List<String> ballColors = BALLS.stream().map(ball -> ball.getColor().name()).toList();
        Assertions.assertTrue(isDescArray(ballColors, ballColors.size()), "Attribute COLOR isn't sorted (desc).");

        Map<Color, double[]> ballCircumferences = new HashMap<>();
        for (Color color :
                Color.values()) {
            ballCircumferences.put(color, BALLS.stream()
                    .filter(ball -> ball.getColor().equals(color))
                    .mapToDouble(Ball::getCircumference)
                    .toArray());
        }

        ballCircumferences.forEach((color, ballCircumferencesPerColor) ->
                Assertions.assertTrue(isAscArray(ballCircumferencesPerColor, ballCircumferencesPerColor.length),
                        "Attribute CIRCUMFERENCE isn't sorted (asc) for TYPE: " + color.name() + "."));
    }

    @Test
    @DisplayName("Sort by COLOR(desc), CIRCUMFERENCE(desc)")
    public void descColorDescCircumferenceSort() {

        Color first = Color.YELLOW;
        Color last = Color.BLACK;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_COLOR, ComparatorType.DESC_CIRCUMFERENCE));

        Assertions.assertEquals(first, BALLS.get(0).getColor(),
                "First element color doesn't match after COLOR(desc), CIRCUMFERENCE(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getColor(),
                "First element color doesn't match after COLOR(desc), CIRCUMFERENCE(desc) sort.");

        List<String> ballColors = BALLS.stream().map(ball -> ball.getColor().name()).toList();
        Assertions.assertTrue(isDescArray(ballColors, ballColors.size()),
                "Attribute COLOR isn't sorted (desc).");

        Map<Color, double[]> ballCircumferences = new HashMap<>();
        for (Color color :
                Color.values()) {
            ballCircumferences.put(color, BALLS.stream()
                    .filter(ball -> ball.getColor().equals(color))
                    .mapToDouble(Ball::getCircumference)
                    .toArray());
        }

        ballCircumferences.forEach((color, ballCircumferencesPerColor) ->
                Assertions.assertTrue(isDescArray(ballCircumferencesPerColor, ballCircumferencesPerColor.length),
                        "Attribute CIRCUMFERENCE isn't sorted (desc) for TYPE: " + color.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), NAME(asc)")
    public void ascTypeAscNameSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.ASC_NAME));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(asc), NAME(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(asc), NAME(asc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, List<String>> ballNames = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballNames.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getName)
                    .toList());
        }

        ballNames.forEach((type, ballNamesPerType) ->
                Assertions.assertTrue(isAscArray(ballNamesPerType, ballNamesPerType.size()),
                        "Attribute NAME isn't sorted (asc) for TYPE: " + type.name() + "."));

    }

    @Test
    @DisplayName("Sort by TYPE(asc), NAME(desc)")
    public void ascTypeDescNameSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.DESC_NAME));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(asc), NAME(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(asc), NAME(desc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, List<String>> ballNames = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballNames.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getName)
                    .toList());
        }

        ballNames.forEach((type, ballNamesPerType) ->
                Assertions.assertTrue(isDescArray(ballNamesPerType, ballNamesPerType.size()),
                        "Attribute NAME isn't sorted (desc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), NAME(asc)")
    public void descTypeAscNameSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.ASC_NAME));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(desc), NAME(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(desc), NAME(asc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, List<String>> ballNames = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballNames.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getName)
                    .toList());
        }

        ballNames.forEach((type, ballNamesPerType) ->
                Assertions.assertTrue(isAscArray(ballNamesPerType, ballNamesPerType.size()),
                        "Attribute NAME isn't sorted (asc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), NAME(desc)")
    public void descTypDescNameSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.DESC_NAME));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(desc), NAME(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(desc), NAME(desc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, List<String>> ballNames = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballNames.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getName)
                    .toList());
        }

        ballNames.forEach((type, ballNamesPerType) ->
                Assertions.assertTrue(isDescArray(ballNamesPerType, ballNamesPerType.size()),
                        "Attribute NAME isn't sorted (desc) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(TO_LARGE), COLOR(CUSTOM_PRIORITY)")
    public void typePriorityToLargeColorCustomPrioritySort() {

        Type firstType = Type.GOLF; // the smallest

        Comparator<Ball> ballComparator = BallComparatorFactory
                .addColorPriorityComparesToChain(Map.of(Color.YELLOW, 1, Color.PINK, 2),
                        BallComparatorFactory.getToLargeSportTypePriorityBallComparator());

        SortingAlgorithm.quickSort(BALLS, ballComparator);

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First element TYPE doesn't match after TYPE(TO_LARGE), COLOR(CUSTOM_PRIORITY) sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getTypePriorityMapBySportScaleAsc()),
                "Type is not sorted according to TO_LARGE TYPE priority map");

        ColorPriorityBuilder colorPriorityBuilder = new ColorPriorityBuilder();
        Map<Color, Integer> colorPriorityMap = colorPriorityBuilder
                .getCustomColorPriorityMap(Map.of(Color.YELLOW, 1, Color.PINK, 2));

        Map<Type, List<Color>> colorsPerTypeMap = new HashMap<>();
        for (Type type :
                Type.values()) {
            colorsPerTypeMap.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getColor)
                    .toList());
        }

        colorsPerTypeMap.forEach((type, colorPerType) ->
                Assertions.assertTrue(isPriorityArray(colorPerType, colorPerType.size(), colorPriorityMap),
                        "Attribute COLOR isn't sorted (CUSTOM_PRIORITY) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(TO_SMALL), COLOR(DARK_TO_LIGHT)")
    public void typePriorityToSmallColorDarkToLightPrioritySort() {

        Type firstType = Type.FOOTBALL; // the smallest
        ColorPriorityBuilder colorPriorityBuilder = new ColorPriorityBuilder();

        Comparator<Ball> ballComparator = BallComparatorFactory
                .addColorPriorityComparesToChain(colorPriorityBuilder.getDarkToLightColorPriorityMap(),
                        BallComparatorFactory.getToSmallSportTypePriorityBallComparator());

        SortingAlgorithm.quickSort(BALLS, ballComparator);

        Assertions.assertEquals(firstType, BALLS.get(0).getType(),
                "First element TYPE doesn't match after TYPE(TO_SMALL), COLOR(DAR_TO_LIGHT) sort.");

        List<Type> types = BALLS.stream()
                .map(Ball::getType).toList();

        TypePriorityBuilder builder = new TypePriorityBuilder();
        Assertions.assertTrue(isPriorityArray(types, types.size(),
                        builder.getTypePriorityMapBySportScaleDesc()),
                "Type is not sorted according to TO_SMALL TYPE priority map");

        Map<Type, List<Color>> colorsPerTypeMap = new HashMap<>();
        for (Type type :
                Type.values()) {
            colorsPerTypeMap.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(Ball::getColor)
                    .toList());
        }

        colorsPerTypeMap.forEach((type, colorPerType) ->
                Assertions.assertTrue(isPriorityArray(colorPerType, colorPerType.size(),
                                colorPriorityBuilder.getDarkToLightColorPriorityMap()),
                        "Attribute COLOR isn't sorted (DAR_TO_LIGHT) for TYPE: " + type.name() + "."));
    }

    @Test
    @DisplayName("Sort by WEIGHT(asc), COLOR(LIGHT_TO_DARK)")
    public void ascWeightToSmallColorDarkToLightPrioritySort() {

        ColorPriorityBuilder colorPriorityBuilder = new ColorPriorityBuilder();

        Comparator<Ball> ballComparator = BallComparatorFactory
                .addColorPriorityComparesToChain(colorPriorityBuilder.getDarkToLightColorPriorityMap(),
                        BallComparatorFactory.getBallComparator.apply(ComparatorType.ASC_WEIGHT));

        SortingAlgorithm.quickSort(BALLS, ballComparator);

        double[] weights = BALLS.stream()
                .mapToDouble(Ball::getWeight)
                .toArray();

        Assertions.assertTrue(isAscArray(weights, weights.length),
                "List isn't sorted asc by attribute WEIGHT.");

        Map<Double, List<Color>> colorsPerTypeMap = new HashMap<>();

        for (Double weight :
                Arrays.stream(weights)
                        .distinct()
                        .toArray()) {

            colorsPerTypeMap.put(weight, BALLS.stream()
                    .filter(ball -> ball.getWeight().equals(weight))
                    .map(Ball::getColor)
                    .toList());
        }

        colorsPerTypeMap.forEach((weight, colorPerWeight) ->
                Assertions.assertTrue(isPriorityArray(colorPerWeight, colorPerWeight.size(),
                                colorPriorityBuilder.getDarkToLightColorPriorityMap()),
                        "Attribute COLOR isn't sorted (LIGHT_TO_DARK) for WEIGHT: " + weight + "."));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), COLOR(asc), WEIGHT(asc)")
    public void ascTypeAscColorAscWeightSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.ASC_COLOR, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(asc), WEIGHT(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(asc), WEIGHT(asc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isAscArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (asc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isAscArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (asc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), COLOR(desc), WEIGHT(desc)")
    public void descTypeDescColorDescWeightSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.DESC_COLOR, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(desc), WEIGHT(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(desc), WEIGHT(desc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isDescArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (desc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isDescArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (desc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), COLOR(desc), WEIGHT(asc)")
    public void ascTypeDescColorAscWeightSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.DESC_COLOR, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(desc), WEIGHT(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(desc), WEIGHT(asc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isDescArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (desc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isAscArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (asc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), COLOR(desc), WEIGHT(asc)")
    public void descTypeDescColorAscWeightSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.DESC_COLOR, ComparatorType.ASC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(desc), WEIGHT(asc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(desc), WEIGHT(asc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isDescArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (desc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isAscArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (asc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    @Test
    @DisplayName("Sort by TYPE(desc), COLOR(asc), WEIGHT(desc)")
    public void descTypeAscColorDescWeightSort() {

        Type first = Type.WATER_POLO;
        Type last = Type.BASEBALL;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.DESC_TYPE, ComparatorType.ASC_COLOR, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(asc), WEIGHT(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(desc), COLOR(asc), WEIGHT(desc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isDescArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (desc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isAscArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (asc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isDescArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (desc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    @Test
    @DisplayName("Sort by TYPE(asc), COLOR(asc), WEIGHT(desc)")
    public void ascTypeAscColorDescWeightSort() {

        Type first = Type.BASEBALL;
        Type last = Type.WATER_POLO;

        SortingAlgorithm.quickSort(BALLS, BallComparatorFactory
                .getBallComparatorChain(ComparatorType.ASC_TYPE, ComparatorType.ASC_COLOR, ComparatorType.DESC_WEIGHT));

        Assertions.assertEquals(first, BALLS.get(0).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(asc), WEIGHT(desc) sort.");
        Assertions.assertEquals(last, BALLS.get(BALLS.size() - 1).getType(),
                "First element color doesn't match after TYPE(asc), COLOR(asc), WEIGHT(desc) sort.");

        List<String> ballTypes = BALLS.stream().map(ball -> ball.getType().name()).toList();
        Assertions.assertTrue(isAscArray(ballTypes, ballTypes.size()),
                "Attribute TYPE isn't sorted (asc).");

        Map<Type, List<String>> ballColors = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballColors.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .map(ball -> ball.getColor().name())
                    .toList());
        }

        ballColors.forEach((type, ballColorsPerType) ->
                Assertions.assertTrue(isAscArray(ballColorsPerType, ballColorsPerType.size()),
                        "Attribute COLOR isn't sorted (asc) for TYPE: " + type.name() + "."));

        Map<Type, List<Ball>> ballsPerType = new HashMap<>();
        for (Type type :
                Type.values()) {
            ballsPerType.put(type, BALLS.stream()
                    .filter(ball -> ball.getType().equals(type))
                    .toList());
        }

        Map<Type, Map<Color, double[]>> weightsPerColorForType = new HashMap<>();

        ballsPerType.forEach((k, v) -> {
            Map<Color, double[]> weightForTypePerCertainColor = new HashMap<>();
            for (Color color :
                    Color.values()) {
                weightForTypePerCertainColor.put(color, v.stream()
                        .filter(ball -> ball.getColor().equals(color))
                        .mapToDouble(Ball::getWeight).toArray());
                weightForTypePerCertainColor.forEach((color1, weights) -> {
                });
            }
            weightsPerColorForType.put(k, weightForTypePerCertainColor);
        });

        weightsPerColorForType.forEach((type, mapOfColorAndWeightArray) ->
                mapOfColorAndWeightArray.forEach((color, weightArray) ->
                        Assertions.assertTrue(isDescArray(weightArray, weightArray.length),
                                "Attribute WEIGHT isn't sorted (desc) for TYPE: " + type.name() + "[" + color + "]")));
    }

    private static <T> boolean isPriorityArray(List<T> array, int n, Map<T, Integer> priority) {
        if (n == 1 || n == 0) return true;
        boolean compareResult = priority.get(array.get(n - 2))
                .compareTo(priority.get(array.get(n - 1))) < 1;
        return compareResult && isPriorityArray(array, n - 1, priority);
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
