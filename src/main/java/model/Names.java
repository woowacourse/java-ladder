package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Names {

    private static final String NAMES_DELIMITER = ",";

    private final List<String> names;

    public Names(String inputNames) {
        names = splitInputNames(inputNames);
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }

    private List<String> splitInputNames(String inputNames) {
        return Arrays.asList(inputNames.split(NAMES_DELIMITER));
    }

}
