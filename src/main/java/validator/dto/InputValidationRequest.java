package validator.dto;

import validator.type.ValidateType;

import java.util.List;

public class InputValidationRequest {

    private final List<ValidateType> validateTypes;
    private final String target;

    public InputValidationRequest(final List<ValidateType> validateTypes, final String target) {
        this.validateTypes = validateTypes;
        this.target = target;
    }

    public List<ValidateType> getValidateTypes() {
        return validateTypes;
    }

    public String getTarget() {
        return target;
    }
}
