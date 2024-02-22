package common.exception.model;

import common.exception.CustomException;

public class NotFoundException extends CustomException {

    public NotFoundException(String message) {
        super(message);
    }
}
