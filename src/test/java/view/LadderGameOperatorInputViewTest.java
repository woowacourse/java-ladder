package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGameOperatorInputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"robin", "phobi", "all"})
    @DisplayName("참가자 이름이거나 all 이 입력된 경우만 제대로 처리되는지 검증")
    void getOperator(String input) {
        String operator = LadderGameOperatorInputView.getOperator(input, List.of("robin", "phobi"));
        Assertions.assertThat(operator)
                .isEqualTo(input);
    }

    @Test
    @DisplayName("잘못된 명령어인지 검증")
    void invalidOperator() {
        Assertions.assertThatThrownBy(() -> LadderGameOperatorInputView.getOperator("aa", List.of("robin", "phobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("없는 참가자 입니다.");
    }
}
