package model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Names {

    private static final String NAMES_DELIMITER = ",";
    private static final String regularExpressionForWhiteSpaceNearbyComma = "\\s*,\\s*";

    private final List<Name> names = new ArrayList<>();

    public Names(String inputNames) {
        for(String name : splitInputNames(inputNames)) {
            names.add(new Name(name));
        }
    }

    public Name getName(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    private List<String> splitInputNames(String inputNames) {
        return Arrays.asList(deleteNearbyWhiteSpaceFromComma(inputNames).split(NAMES_DELIMITER));
    }

    private String deleteNearbyWhiteSpaceFromComma(String inputValue) {
        return inputValue.replaceAll(regularExpressionForWhiteSpaceNearbyComma, NAMES_DELIMITER);
    }

}
