package dto;

import type.ValidateType;

import java.util.List;

public class InputValidationRequest {

    private final List<ValidateType> validateTypes;
    private final String target;

    public InputValidationRequest(List<ValidateType> validateTypes, String target) {
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
