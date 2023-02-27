package view;

import exception.ErrorMessage;

public class InputValidator {

    public int validateHeight(final String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_NON_NUMERIC_EXCEPTION.getMessage());
        }
    }
}
