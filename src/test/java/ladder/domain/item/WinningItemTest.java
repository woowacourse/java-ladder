package ladder.domain;

import ladder.domain.item.WinningItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 아이템")
public class WinningItemTest {
    @DisplayName("이름이 비어있거나 공백인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void nameBlankExceptionTest(String winningItemName) {
        assertThatThrownBy(() -> new WinningItem(winningItemName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 아이템의 이름은 비어있거나 공백일 수 없습니다.");
    }
}
