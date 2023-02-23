package domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemTest {

    @Test
    @DisplayName("아이템의 길이가 1~5인 경우, 예외가 발생하지 않는다.")
    void validateItemLength_Success() {
        assertThatNoException().isThrownBy(() -> new Item("십만원"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "100000"})
    @DisplayName("아이템의 길이가 1~5가 아닌 경우, 예외가 발생한다.")
    void validateItemLength_Fail(String item) {
        assertThatThrownBy(() -> new Item(item))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과의 길이는 1이상 5이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 당첨", "당 첨", "당첨 ", " "})
    @DisplayName("아이템에 공백이 있는 경우 예외가 발생한다.")
    void validateItemWithSpace_Fail(String item) {
        assertThatThrownBy(() -> new Item(item))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과에는 공백이 들어갈 수 없습니다.");
    }
}
