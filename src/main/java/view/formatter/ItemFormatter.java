package view.formatter;

import java.util.List;

public class ItemFormatter {
    public static String format(final List<String> itemName) {
        final List<String> formattedItemNames = itemName.stream()
                .map(ItemFormatter::format)
                .toList();
        return String.join(" ", formattedItemNames);
    }

    public static String format(final String itemName) {
        return String.format("%-4s", itemName);
    }
}
