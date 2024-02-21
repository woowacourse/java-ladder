package formatter;

import java.util.List;

public class NamesFormatter {

    public static String format(List<String> names) {
        List<String> formattedNames = names.stream()
                .map(NameFormatter::format)
                .toList();
        return String.join(" ", formattedNames).stripTrailing();
    }
}
