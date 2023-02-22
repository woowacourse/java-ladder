package validator;

import validator.dto.InputValidationRequest;

public interface InputValidatorChain {

    void setNext(InputValidatorChain validator);

    void validate(InputValidationRequest request) throws IllegalArgumentException;
}
