package view;

import ladder.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @DisplayName(",로 구분하여 이름을 입력하면 List<String>로 반환한다.")
    @Test
    void parseNamesWithDelimiter() {
        List<String> names = InputView.readNames(() -> "a,b,c");
        assertThat(names).containsExactly("a", "b", "c");
    }

    @DisplayName("사용자 이름으로 공백이 입력되면 예외를 던진다.")
    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void validateNamesWithNullOrEmpty(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.readNames(() -> input))
                .withMessage("사용자 이름으로 공백을 넣을 수 없습니다.");
    }
}
