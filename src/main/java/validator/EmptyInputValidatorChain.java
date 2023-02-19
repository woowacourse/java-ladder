package validator;

import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

public class EmptyInputValidatorChain implements InputValidator {

    private static final String ERROR_MESSAGE = "빈 값은 허용되지 않습니다.";

    @Override
    public void validate(InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.EMPTY_VALUE)) {
            return;
        }
        if (request.getTarget().isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
