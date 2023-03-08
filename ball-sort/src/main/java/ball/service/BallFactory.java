package ball.service;

import ball.dto.BallProductionRequest;
import ball.entity.balls.Ball;
import ball.entity.basket.Basket;
import ball.mapper.BallRequestToBallMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallFactory {

    private int basketNumber = 0;

    private final Random random;

    public BallFactory() {
        this.baskets = new ArrayList<>();
        this.random = new Random();
    }

    private final List<Basket> baskets;

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void addBasket(Basket basket) {
        this.baskets.add(basket);
        increaseBasketNumber();
    }

    public long getBasketNumber() {
        return basketNumber;
    }

    private void increaseBasketNumber() {
        this.basketNumber++;
    }

    public Ball produceBall(BallProductionRequest ballProductionRequest) {
        Ball producedBall = new BallRequestToBallMapper().apply(ballProductionRequest);
        addBallToBasket(producedBall);
        return producedBall;
    }

    public void addBallToBasket(Ball ball) {
        this.baskets.get(lessLoadedBasketIndex()).addBall(ball);
    }

    public int lessLoadedBasketIndex() {

        int lessLoadedBasket = this.baskets.stream()
                .mapToInt(basket -> basket.getBalls().size())
                .min()
                .orElse(random.nextInt((basketNumber - 1)));

        for (int i = 0; i < this.baskets.size(); i++) {
            if (baskets.get(i).getBalls().size() == lessLoadedBasket)
                return i;
        }
        return 0;
    }
}
