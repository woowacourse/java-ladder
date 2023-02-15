package ladder.view;

import ladder.exception.NotIntegerException;

public class InputValidator {

    public static void validateInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }
}
