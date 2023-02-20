package validator;

import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

public class EmptyInputValidatorChain implements InputValidator {

    private static final String ERROR_MESSAGE = "빈 값은 허용되지 않습니다.";
    private InputValidator next;

    @Override
    public void setNext(final InputValidator validator) {
        this.next = validator;
    }

    @Override
    public void validate(final InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.EMPTY_VALUE)) {
            next.validate(request);
        }
        if (request.getTarget().isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        next.validate(request);
    }
}
