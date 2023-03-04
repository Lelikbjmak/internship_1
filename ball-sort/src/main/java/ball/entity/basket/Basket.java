package ball.entity.basket;

import ball.entity.balls.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * Basket - Stash all our {@link Ball}
 */
public class Basket {

    private final ArrayList<Ball> balls;

    public Basket() {
        balls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void addSeveralBalls(List<Ball> ballList) {
        balls.addAll(ballList);
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
