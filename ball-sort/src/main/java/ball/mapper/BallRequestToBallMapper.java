package ball.mapper;

import ball.dto.BallProductionRequest;
import ball.entity.balls.*;
import ball.entity.types.Type;

import java.util.function.Function;

public class BallRequestToBallMapper implements Function<BallProductionRequest, Ball> {

    @Override
    public Ball apply(BallProductionRequest ballProductionRequest) {

        Type type = ballProductionRequest.type();
        switch (type) {
            case GOLF -> {
                return new GolfBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case VOLLEYBALL -> {
                return new VolleyballBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case BASEBALL -> {
                return new BaseballBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case BASKETBALL -> {
                return new BasketballBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case WATER_POLO -> {
                return new WaterPoloBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case FOOTBALL -> {
                return new FootballBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case TENNIS -> {
                return new TennisBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case SOCCER -> {
                return new SoccerBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
            case HANDBALL -> {
                return new HandballBall(ballProductionRequest.name(), ballProductionRequest.circumference(),
                        ballProductionRequest.weight(), ballProductionRequest.color());
            }
        }

        return null;
    }
}
