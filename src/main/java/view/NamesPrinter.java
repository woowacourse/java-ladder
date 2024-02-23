package view;

import java.util.List;
import java.util.stream.Collectors;

public class NamesPrinter {
    public static String from(List<String> names) {
        return names.stream()
                .map(NamePrinter::from)
                .collect(Collectors.joining(" "));
    }
}
