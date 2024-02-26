package controller;

import domain.Height;
import domain.LadderResult;
import domain.LadderResults;
import domain.Name;
import domain.Names;
import java.util.Arrays;
import java.util.List;

public class InputMapper {
    private static final String NAME_DELIMITER = ",";
    private static final String RESULT_DELIMITER = ",";

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

    public LadderResults mapToLadderResults(String target) {
        return new LadderResults(Arrays.stream(target.split(RESULT_DELIMITER))
                .map(LadderResult::new)
                .toList());
    }

    private void validateInputNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값이 아닙니다");
        }
    }
}
