package validator;

import validator.dto.InputValidationRequest;

public class SuccessInputValidatorChain implements InputValidatorChain {

    @Override
    public void setNext(final InputValidatorChain validator) {
    }

    @Override
    public void validate(final InputValidationRequest request) throws IllegalArgumentException {
    }
}
