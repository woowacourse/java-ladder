package domain;

import java.util.stream.Collectors;

class NamesPrinter {
    static String from(Names names) {
        return names.getNames().stream()
                .map(NamePrinter::from)
                .collect(Collectors.joining(" "));
    }
}
