package laddergame.view;

import java.util.List;

public class WidthCalculator {

    private static final int DEFAULT_SIZE = 5;

    private WidthCalculator() {
    }

    public static int calculateWidth(final List<String> names) {
        final int lastLength = getLastLength(names);

        if (lastLength == DEFAULT_SIZE) {
            return DEFAULT_SIZE + 1;
        }

        return DEFAULT_SIZE;
    }

    private static int getLastLength(final List<String> names) {
        return names.get(names.size() - 1).length();
    }

    public static int calculateFirstWidth(final List<String> names) {
        return names.get(0).length();
    }
}
