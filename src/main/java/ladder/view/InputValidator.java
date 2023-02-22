package ladder.view;

import ladder.domain.exception.NotIntegerException;

public class InputValidator {

    public static void validateInteger(final String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }
}
