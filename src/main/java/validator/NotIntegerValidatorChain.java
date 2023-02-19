package validator;

import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.regex.Pattern;

public class NotIntegerValidatorChain implements InputValidator {
    private static final String ERROR_MESSAGE = "정수 외 숫자는 입력이 허용되지 않습니다.";
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.INTEGER_VALUE)) {
            return;
        }
        if (!INTEGER_PATTERN.matcher(request.getTarget()).matches() || request.getTarget().equals("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
