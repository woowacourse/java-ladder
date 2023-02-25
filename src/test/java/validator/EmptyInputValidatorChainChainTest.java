package validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EmptyInputValidatorChainChainTest {

    private final InputValidatorChain validator = new EmptyInputValidatorChain();

    @ParameterizedTest(name = "빈 값 검사 테스트")
    @ValueSource(strings = {"", " "})
    void testEmptyInput(String input) {
        InputValidationRequest request = new InputValidationRequest(List.of(ValidateType.EMPTY_VALUE), input);

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
