package validator;

import dto.InputValidationRequest;

public class SuccessInputValidatorChain implements InputValidator {

    @Override
    public void setNext(InputValidator validator) {
    }

    @Override
    public void validate(InputValidationRequest request) throws IllegalArgumentException {
    }
}
