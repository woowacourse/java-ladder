package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {
    private static final String NAMES_DELIMITER = ",";

    private final List<Name> names = new ArrayList<>();

    public Names(String inputNames) {
        splitInputNames(inputNames).stream()
                .map(String::strip)
                .forEach(name -> names.add(new Name(name)));
    }

    public Name getName(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    private List<String> splitInputNames(String inputNames) {
        return Arrays.asList(inputNames.split(NAMES_DELIMITER));
    }
}
