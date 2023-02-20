package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameFactory {
    private static final String NAMES_DELIMITER = ",";

    public static List<Name> create(String inputNames) {
        return splitInputNames(inputNames).stream()
                .map(String::strip)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitInputNames(String inputNames) {
        return Arrays.asList(inputNames.split(NAMES_DELIMITER));
    }
}
