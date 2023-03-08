package com.innowise.ball_factory.builder;

import com.innowise.ball_factory.comparator.Prioritized;
import com.innowise.ball_factory.entity.ball_const_field_types.Type;

import java.util.EnumMap;
import java.util.Map;

public class TypePriorityBuilder implements Prioritized<Type> {

    private Map<Type, Integer> getEqualTypePriorityMap() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, 0);
        }
        return priorityTypeMap;
    }

    private Map<Type, Integer> getCustomTypePriorityMap(Map<Type, Integer> typeIntegerMap) {
        Map<Type, Integer> priorityTypeMap = getEqualTypePriorityMap();
        priorityTypeMap.forEach(typeIntegerMap::replace);
        return priorityTypeMap;
    }

    private Map<Type, Integer> getTypePriorityMapBySportScaleAsc() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, Type.values().length - type.ordinal());
        }
        return priorityTypeMap;
    }

    private Map<Type, Integer> getTypePriorityMapBySportScaleDesc() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, type.ordinal());
        }
        return priorityTypeMap;
    }

    @Override
    public Map<Type, Integer> getCustomPriorityMap(Map<Type, Integer> customPriorityMap) {
        return getCustomTypePriorityMap(customPriorityMap);
    }

    @Override
    public Map<Type, Integer> getAscPriorityMap() {
        return getTypePriorityMapBySportScaleAsc();
    }

    @Override
    public Map<Type, Integer> getDescPriorityMap() {
        return getTypePriorityMapBySportScaleDesc();
    }
}
