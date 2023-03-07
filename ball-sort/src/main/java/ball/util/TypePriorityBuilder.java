package ball.util;

import ball.entity.types.Type;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public class TypePriorityBuilder {

    private final Random random;

    public TypePriorityBuilder() {
        this.random = new Random();
    }

    public Map<Type, Integer> getEqualTypePriorityMap() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, 0);
        }
        return priorityTypeMap;
    }

    public Map<Type, Integer> getCustomTypePriorityMap(Map<Type, Integer> typeIntegerMap) {
        Map<Type, Integer> priorityTypeMap = getEqualTypePriorityMap();
        priorityTypeMap.forEach(typeIntegerMap::replace);
        return priorityTypeMap;
    }

    public Map<Type, Integer> getTypePriorityMapBySportScaleAsc() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, Type.values().length - type.ordinal());
        }
        return priorityTypeMap;
    }

    public Map<Type, Integer> getTypePriorityMapBySportScaleDesc() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, type.ordinal());
        }
        return priorityTypeMap;
    }

    public Map<Type, Integer> getRandomTypePriorityMap() {
        Map<Type, Integer> priorityTypeMap = new EnumMap<>(Type.class);
        for (Type type :
                Type.values()) {
            priorityTypeMap.put(type, this.random.nextInt(100 - 1) + 1);
        }
        return priorityTypeMap;
    }
}
