package ball.dto;

import ball.entity.types.Color;
import ball.entity.types.Type;

public record BallProductionRequest(String name, Type type, Color color,
                                    Double weight, Double circumference) {
}
