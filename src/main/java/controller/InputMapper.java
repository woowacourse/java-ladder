package controller;

import domain.Height;
import domain.Names;
import java.util.Arrays;
import java.util.List;

public class InputMapper {

    public Names mapToNames(String target) {
        List<String> names = Arrays.asList(target.split(","));
        return Names.from(names);
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
