package common.exception.model;

import common.exception.CustomException;

public class ValidationException extends CustomException {

    public ValidationException(String message) {
        super(message);
    }
}
