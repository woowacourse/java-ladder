package common.exception.model;

import common.exception.CustomException;

public class NotFoundException extends CustomException {

    public NotFoundException(final String message) {
        super(message);
    }
}
