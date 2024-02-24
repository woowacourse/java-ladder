package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGameOperatorInputViewTest {
    @Test
    @DisplayName("결과를 확인하고 싶은 이름이 입력되지 않은 이름인 경우 검증")
    void validateNameNotFound() {
        assertThatThrownBy(
                () -> LadderGameOperatorInputView.getOperator(() -> "abc", List.of("abcd,ab")))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAME_NOT_FOUND.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "all"})
    @DisplayName("결과를 확인하고 싶은 이름이 입력되지 않은 이름인 경우 검증")
    void getNameThatNeedToShowResult(String name) {
        String nameThatNeedToShowResult = LadderGameOperatorInputView.getOperator(() -> name,
                List.of("a", "b", "c"));
        Assertions.assertThat(nameThatNeedToShowResult)
                .isEqualTo(name);
    }
}
