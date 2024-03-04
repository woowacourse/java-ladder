package formatter;

import java.util.List;

public class PresentNamesFormatter {

    public static String format(final List<String> names) {
        final List<String> formattedNames = names.stream()
                .map(PresentNameFormatter::format)
                .toList();
        return String.join(" ", formattedNames).stripTrailing();
    }
}
