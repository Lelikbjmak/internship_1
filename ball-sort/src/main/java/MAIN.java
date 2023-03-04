import ball.entity.ball_comparator.ComparatorType;
import ball.entity.balls.BaseballBall;
import ball.entity.balls.BasketballBall;
import ball.entity.balls.FootballBall;
import ball.entity.basket.Basket;
import ball.entity.factory.BallComparatorFactory;
import ball.entity.factory.BallFactory;
import ball.entity.types.Color;
import ball.sorts.QuickSort;

import java.util.List;

public class MAIN {

    public static void main(String[] args) {

        BallFactory ballFactory = new BallFactory();
        Basket basket = new Basket();

        basket.addSeveralBalls(List.of(
                new FootballBall("WX-195", 5.5, 776.12, Color.YELLOW),
                new BaseballBall("AX-197", 15.5, 123.00, Color.PURPLE),
                new BaseballBall("VM-205", 5.5, 99.0, Color.PINK),
                new FootballBall("BM-203", 35.5, 699.99, Color.BROWN),
                new BaseballBall("AM-204", 86.5, 120.0, Color.RED),
                new FootballBall("CM-202", 25.5, 887.0, Color.WHITE),
                new BasketballBall("FX-190", 35.5, 1349.00, Color.GREY),
                new BasketballBall("KX-192", 745.5, 1450.90, Color.GREEN),
                new BaseballBall("SX-193", 2.5, 106.62, Color.ORANGE),
                new FootballBall("ZX-198", 25.5, 949.00, Color.BLACK)
        ));

        ballFactory.addBasket(basket);

        QuickSort.sort(ballFactory.getBaskets().get(0).getBalls(), true, BallComparatorFactory.getBallComparator.apply(ComparatorType.TYPE));

        basket.getBalls().forEach(System.out::println);
    }

}
