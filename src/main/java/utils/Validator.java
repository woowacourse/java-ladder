package utils;

import static utils.constants.ErrorMessages.DUPLICATED_INPUT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateDuplication(final List<String> inputs) {
        Set<String> inputsWithoutDuplication = new HashSet<>(inputs);
        if (inputs.size() != inputsWithoutDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT.getMessage());
        }
    }
}
