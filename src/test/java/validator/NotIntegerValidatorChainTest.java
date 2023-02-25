package validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NotIntegerValidatorChainTest {
    private static final InputValidatorChain validator = new NotIntegerValidatorChain();

    @BeforeAll
    static void setUp() {
        validator.setNext(new SuccessInputValidatorChain());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "q", "-1"})
    @DisplayName("정수가 아닌 경우 테스트")
    void testNotInteger(String input) {
        InputValidationRequest request = new InputValidationRequest(List.of(ValidateType.INTEGER_VALUE), input);

        assertThatThrownBy(() -> validator.validate(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22345", "3123412"})
    @DisplayName("정수일 경우 테스트.")
    void testInteger(String input) {
        InputValidationRequest request = new InputValidationRequest(List.of(ValidateType.INTEGER_VALUE), input);

        assertThatNoException().isThrownBy(() -> validator.validate(request));
    }

}
