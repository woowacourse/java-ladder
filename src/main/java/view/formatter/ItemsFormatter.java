package view.formatter;

import java.util.List;

public class ItemsFormatter {
    public static String format(final List<String> itemName) {
        final List<String> formattedItemNames = itemName.stream()
                .map(ItemFormatter::format)
                .toList();
        return String.join(" ", formattedItemNames);
    }
}
