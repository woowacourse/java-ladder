package domain;

import java.util.stream.Collectors;

public class NamesString {
    public static String from(Names names) {
        return names.getNames().stream()
                .map(NameString::from)
                .collect(Collectors.joining(" "));
    }
}
