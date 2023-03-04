package ball.entity.factory;

import ball.entity.basket.Basket;

import java.util.ArrayList;
import java.util.List;

public class BallFactory {

    public BallFactory() {
        this.baskets = new ArrayList<>();
    }

    public BallFactory(List<Basket> baskets) {
        this.baskets = new ArrayList<>(baskets);
    }

    private final List<Basket> baskets;

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void addBasket(Basket basket) {
        this.baskets.add(basket);
    }
}
