package ball.util;

import ball.entity.types.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorPriorityBuilder {

    public ColorPriorityBuilder() {
    }

    private Map<Color, Integer> getEqualPriorityColorMap() {
        Map<Color, Integer> priorityColorMap = new HashMap<>();
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, Color.values().length);
        }
        return priorityColorMap;
    }

    public Map<Color, Integer> getCustomColorPriorityMap(Map<Color, Integer> priorityColorMap) {
        Map<Color, Integer> colorIntegerMap = getEqualPriorityColorMap();
        priorityColorMap.forEach(colorIntegerMap::replace);
        return colorIntegerMap;
    }

    public Map<Color, Integer> getDarkToLightColorPriorityMap() {
        Map<Color, Integer> priorityColorMap = new HashMap<>();
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, color.ordinal());
        }
        return priorityColorMap;
    }

    public Map<Color, Integer> getLightToDarkColorPriorityMap() {
        Map<Color, Integer> priorityColorMap = new HashMap<>();
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, Color.values().length - color.ordinal());
        }
        return priorityColorMap;
    }

    public Map<Color, Integer> getRandomColorPriorityMap() {
        Map<Color, Integer> priorityColorMap = new HashMap<>();
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, new Random().nextInt(100 - 1) + 1);
        }
        return priorityColorMap;
    }
}
