package validator.dto;

import validator.type.ValidateType;

import java.util.ArrayList;
import java.util.List;

public class InputValidationRequest {

    private final List<ValidateType> validateTypes;
    private final String target;

    public InputValidationRequest(List<ValidateType> validateTypes, String target) {
        this.validateTypes = new ArrayList<>(validateTypes);
        this.target = target;
    }

    public List<ValidateType> getValidateTypes() {
        return List.copyOf(validateTypes);
    }

    public String getTarget() {
        return target;
    }
}
