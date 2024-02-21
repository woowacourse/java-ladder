package domain;

import java.util.stream.Collectors;

class NamesString {
    static String from(Names names) {
        return names.getNames().stream()
                .map(NameString::from)
                .collect(Collectors.joining(" "));
    }
}
