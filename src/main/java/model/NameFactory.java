package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameFactory {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 참가자 이름은 중복될 수 없습니다.";
    private static final String NAMES_DELIMITER = ",";

    public static List<Name> create(String inputNames) {
        List<String> names = splitInputNames(inputNames);
        validateDuplicatedNames(names);
        return names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitInputNames(String inputNames) {
        return Arrays.stream(inputNames.split(NAMES_DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private static void validateDuplicatedNames(List<String> names) {
        if(names.size() != getDistinctCount(names)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    private static int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }


}
