package validator;

import java.util.regex.Pattern;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

public class NotIntegerValidatorChain implements InputValidatorChain {

    private static final String ERROR_MESSAGE = "정수 외 숫자는 입력이 허용되지 않습니다.";
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[0-9]*$");
    public static final String ZERO = "0";
    private InputValidatorChain next;

    @Override
    public void setNext(final InputValidatorChain validator) {
        this.next = validator;
    }

    @Override
    public void validate(final InputValidationRequest request) throws IllegalArgumentException {
        if (!request.getValidateTypes().contains(ValidateType.INTEGER_VALUE)) {
            next.validate(request);
            return;
        }
        if (!INTEGER_PATTERN.matcher(request.getTarget()).matches() || request.getTarget()
            .equals(ZERO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        next.validate(request);
    }
}
