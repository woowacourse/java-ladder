package validator;

import validator.dto.InputValidationRequest;

import java.util.List;

public class InputValidators implements InputValidator {

    final List<InputValidator> values;

    public InputValidators(List<InputValidator> values) {
        this.values = values;
    }
    @Override
    public void validate(InputValidationRequest request) throws IllegalArgumentException {
        values.forEach(value -> value.validate(request));
    }

    public void add(InputValidator inputValidator) {
        values.add(inputValidator);
    }
}
