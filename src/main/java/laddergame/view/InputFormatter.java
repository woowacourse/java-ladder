package laddergame.view;

import java.util.List;
import java.util.stream.Collectors;

public class InputFormatter {

    private InputFormatter() {
    }

    public static String formatNames(final List<String> names) {
        final int width = WidthCalculator.calculateWidth(names);

        return formatFirstName(names)
                + formatMiddleName(names, width)
                + formatLastName(names, width);
    }

    public static String formatTargets(final List<String> targets) {
        return targets.stream()
                .map(target -> String.format("%-6s", target))
                .collect(Collectors.joining());
    }

    private static String formatFirstName(final List<String> names) {
        return names.get(0) + " ";
    }

    private static String formatMiddleName(final List<String> names, final int width) {
        return names.stream()
                .skip(1)
                .limit(names.size() - 2)
                .map(name -> String.format("%" + (width + 1) + "s", name))
                .collect(Collectors.joining());
    }

    private static String formatLastName(final List<String> names, final int width) {
        final String lastName = names.get(names.size() - 1);
        return String.format("%" + width + "s", lastName);
    }

}
