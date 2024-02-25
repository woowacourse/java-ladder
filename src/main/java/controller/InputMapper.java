package controller;

import domain.Height;
import domain.Name;
import domain.Names;
import java.util.Arrays;
import java.util.List;

public class InputMapper {
    private static final String NAME_DELIMITER = ",";

    public Names mapToNames(String target) {
        List<String> names = Arrays.asList(target.split(NAME_DELIMITER));
        return new Names(names.stream()
                .map(Name::new)
                .toList());
    }

    public Height mapToHeight(String target) {
        validateInputNumeric(target);
        return new Height(Integer.parseInt(target));
    }

    private void validateInputNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값이 아닙니다");
        }
    }
}
