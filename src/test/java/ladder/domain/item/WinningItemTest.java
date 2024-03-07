package ladder.domain;

import ladder.domain.item.WinningItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 아이템")
public class WinningItemTest {
    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        // given
        String name = "당첨입니다";

        // when
        WinningItem winningItem = new WinningItem(name);

        // then
        assertThat(winningItem).extracting("name")
                .isEqualTo(name);
    }

    @DisplayName("이름이 5글자를 넘어가면 예외가 발생한다.")
    @Test
    void nameMaxLengthExceptionTest() {
        assertThatThrownBy(() -> new WinningItem("naknak"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 아이템 이름의 길이는 5자 이하이어야 합니다.");
    }

    @DisplayName("이름이 비어있거나 공백인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void nameBlankExceptionTest(String winningItemName) {
        assertThatThrownBy(() -> new WinningItem(winningItemName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 아이템의 이름은 비어있거나 공백일 수 없습니다.");
    }

}
