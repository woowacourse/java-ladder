package validator;

import validator.dto.InputValidationRequest;

import java.util.ArrayList;

@FunctionalInterface
public interface InputValidator {

    void validate(InputValidationRequest request) throws IllegalArgumentException;

    static Builder builder() {
        return new Builder();
    }

    class Builder {

        private final InputValidators inputValidators;

        public Builder() {
            this.inputValidators = new InputValidators(new ArrayList<>());
        }

        public Builder add(InputValidator inputValidator) {
            inputValidators.add(inputValidator);
            return this;
        }

        public InputValidator build() {
            return inputValidators;
        }
    }
}
