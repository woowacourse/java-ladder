package exception;

import view.input.ErrorMessage;

public class NotFindPersonException extends IllegalArgumentException {

    public NotFindPersonException() {
        super(ErrorMessage.NOT_FIND_PERSON.getMessage());
    }
}
