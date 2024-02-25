package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomElementSelector {

    private RandomElementSelector() {
    }

    public static <T extends Enum<?>> T selectRandomConstant(Class<T> enumClass) {
        return selectRandomElement(Arrays.asList(enumClass.getEnumConstants()));
    }

    private static <T> T selectRandomElement(List<T> collection) {
        Collections.shuffle(collection);
        return collection.get(0);
    }
}
