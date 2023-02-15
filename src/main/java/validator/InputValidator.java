package validator;

import dto.InputValidationRequest;

public interface InputValidator {

    void setNext(InputValidator validator);

    void validate(InputValidationRequest request) throws IllegalArgumentException;
}
