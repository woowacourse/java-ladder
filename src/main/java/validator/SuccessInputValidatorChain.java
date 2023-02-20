package validator;

import validator.dto.InputValidationRequest;

public class SuccessInputValidatorChain implements InputValidator {

    @Override
    public void setNext(final InputValidator validator) {
    }

    @Override
    public void validate(final InputValidationRequest request) throws IllegalArgumentException {
    }
}
