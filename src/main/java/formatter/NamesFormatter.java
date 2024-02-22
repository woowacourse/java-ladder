package formatter;

import java.util.List;

public class NamesFormatter {

    public static String format(final List<String> names) {
        final List<String> formattedNames = names.stream()
                .map(NameFormatter::format)
                .toList();
        return String.join(" ", formattedNames).stripTrailing();
    }
}
