package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Name> Names = new ArrayList<>();

    public Names(String names) {
        for (String name : splitNames(names)) {
            Names.add(new Name(name));
        }
    }

    private List<String> splitNames(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(Names);
    }

    public int getNamesSize() {
        return Names.size();
    }
}
