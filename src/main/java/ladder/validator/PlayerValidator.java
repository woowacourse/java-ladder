package ladder.validator;

import ladder.constant.MessageConstant;

public class PlayerValidator {

    public static final int MAX_NAME_LENGTH = 5;

    public static String validatedName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_HAS_VALUE_EMPTY);
        }
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLENGTH);
        }
        return name.trim();
    }

}
