package laddergame.view;

import java.util.Comparator;
import java.util.List;

public class WidthCalculator {

    private WidthCalculator() {
    }

    public static int calculateWidth(final List<String> names) {
        final int maxLengthSkipFirst = getMaxLengthSkipFirst(names);
        final int lastLength = getLastLength(names);

        if (maxLengthSkipFirst == lastLength) {
            return lastLength + 1;
        }

        return maxLengthSkipFirst;
    }

    private static int getMaxLengthSkipFirst(final List<String> names) {
        return names.stream()
                .map(String::length)
                .skip(1)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    private static int getLastLength(final List<String> names) {
        return names.get(names.size() - 1).length();
    }

    public static int calculateFirstWidth(final List<String> names) {
        return names.get(0).length();
    }
}
