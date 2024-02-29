package ladder.view.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력이 비어있으면 예외가 발생한다.")
    void validateInputBlank(String input) {
        assertThatThrownBy(() -> inputValidator.validateInputBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("참여할 사람의 이름이 'all'을 포함하면 예외가 발생한다.")
    void validatePlayerNames() {
        String input = "pobi,honux,all";

        assertThatThrownBy(() -> inputValidator.validatePlayerNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여할 사람의 이름이 'all' 일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12!", "12a", "12@"})
    @DisplayName("최대 사다리 높이에 대한 입력이 숫자가 아니면 예외가 발생한다.")
    void validateLadderHeight(String input) {
        assertThatThrownBy(() -> inputValidator.validateLadderHeight(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 높이에 대한 입력은 숫자어야 합니다.");
    }
}
