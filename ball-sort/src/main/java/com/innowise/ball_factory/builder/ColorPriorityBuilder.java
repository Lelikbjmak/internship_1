package com.innowise.ball_factory.builder;

import com.innowise.ball_factory.comparator.Prioritized;
import com.innowise.ball_factory.entity.ball_const_field_types.Color;

import java.util.EnumMap;
import java.util.Map;

public class ColorPriorityBuilder implements Prioritized<Color> {

    private Map<Color, Integer> getEqualPriorityColorMap() {
        Map<Color, Integer> priorityColorMap = new EnumMap<>(Color.class);
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, Color.values().length);
        }
        return priorityColorMap;
    }

    private Map<Color, Integer> getCustomColorPriorityMap(Map<Color, Integer> priorityColorMap) {
        Map<Color, Integer> colorIntegerMap = getEqualPriorityColorMap();
        priorityColorMap.forEach(colorIntegerMap::replace);
        return colorIntegerMap;
    }

    private Map<Color, Integer> getDarkToLightColorPriorityMap() {
        Map<Color, Integer> priorityColorMap = new EnumMap<>(Color.class);
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, color.ordinal());
        }
        return priorityColorMap;
    }

    private Map<Color, Integer> getLightToDarkColorPriorityMap() {
        Map<Color, Integer> priorityColorMap = new EnumMap<>(Color.class);
        for (Color color :
                Color.values()) {
            priorityColorMap.put(color, Color.values().length - color.ordinal());
        }
        return priorityColorMap;
    }

    @Override
    public Map<Color, Integer> getCustomPriorityMap(Map<Color, Integer> customPriorityMap) {
        return getCustomColorPriorityMap(customPriorityMap);
    }

    @Override
    public Map<Color, Integer> getAscPriorityMap() {
        return getDarkToLightColorPriorityMap();
    }

    @Override
    public Map<Color, Integer> getDescPriorityMap() {
        return getLightToDarkColorPriorityMap();
    }
}
