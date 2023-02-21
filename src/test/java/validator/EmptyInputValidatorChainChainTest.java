package validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EmptyInputValidatorChainChainTest {

    private final InputValidatorChain validator = new EmptyInputValidatorChain();

    @ParameterizedTest(name = "{0} 빈 값은 허용되지 않는다.")
    @ValueSource(strings = {"", " "})
    void emptyInputValidateTest(String input) {
        InputValidationRequest request = new InputValidationRequest(List.of(ValidateType.EMPTY_VALUE), input);

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
