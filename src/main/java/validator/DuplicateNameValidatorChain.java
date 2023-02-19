package validator;

import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNameValidatorChain implements InputValidator {

    private static final String ERROR_MESSAGE = "중복은 허용되지 않습니다.";
    private final List<String> names = new ArrayList<>();

    @Override
    public void validate(InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.DUPLICATE_VALUE)) {
            return;
        }
        String trimmedTarget = request.getTarget().trim();
        if (names.contains(trimmedTarget)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        names.add(trimmedTarget);
    }
}
