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

    public void validateAscii(final String userNames) {
        int stringByte = userNames.getBytes().length;
        int stringLength = userNames.length();
        if ((stringByte - stringLength) != 0) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_NON_ASCII_CHARACTER_EXCEPTION.getMessage());
        }
    }
}
