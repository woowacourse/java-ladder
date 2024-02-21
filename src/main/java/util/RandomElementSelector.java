package util;

import java.util.Collections;
import java.util.List;

public class RandomElementSelector {

    private RandomElementSelector() {
    }

    public static <T> T selectRandomElement(List<T> collection) {
        Collections.shuffle(collection);
        return collection.get(0);
    }
}
