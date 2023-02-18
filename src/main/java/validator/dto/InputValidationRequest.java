package validator.dto;

import validator.type.ValidateType;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class InputValidationRequest {

    private final List<ValidateType> validateTypes;
    private final String target;

    public InputValidationRequest(List<ValidateType> validateTypes, String target) {
        this.validateTypes = new ArrayList<>(validateTypes);
        this.target = target;
    }

    public List<ValidateType> getValidateTypes() {
        return Collections.unmodifiableList(validateTypes);
    }

    public String getTarget() {
        return target;
    }
}
