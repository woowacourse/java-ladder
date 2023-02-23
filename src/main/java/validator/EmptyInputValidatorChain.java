package validator;

import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

public class EmptyInputValidatorChain implements InputValidatorChain {

    private static final String ERROR_MESSAGE = "빈 값은 허용되지 않습니다.";
    private InputValidatorChain next;

    @Override
    public void setNext(final InputValidatorChain validator) {
        this.next = validator;
    }

    @Override
    public void validate(final InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.EMPTY_VALUE)) {
            next.validate(request);
            return;
        }
        if (request.getTarget().isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        next.validate(request);
    }
}
