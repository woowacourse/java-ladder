package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftsInputViewTest {

    @Test
    @DisplayName("상품 이름을 구분자로 잘 자르는지 검증")
    void getGiftNames() {
        List<String> giftNames = GiftsInputView.getGiftNames("robin,phobi,12345,test1", 4);
        Assertions.assertThat(giftNames)
                .containsExactlyElementsOf(List.of("robin", "phobi", "12345", "test1"));
    }

    @Test
    @DisplayName("연속된 구분자가 입력된 경우 실행 안되는지 검증")
    void validateDuplicateSeparator() {
        Assertions.assertThatThrownBy(() -> GiftsInputView.getGiftNames("robin,,a", 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 구분자가 연속으로 등장하면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",robin,phobi", "robin,phobi,"})
    @DisplayName("구분자로 시작하거나 끝나도록 입력된 경우 실행 안되는지 검증")
    void validateStartOrEndWithSeparator(String input) {
        Assertions.assertThatThrownBy(() -> GiftsInputView.getGiftNames(input, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 구분자로 시작하거나 끝나면 안됩니다.");
    }

    @Test
    @DisplayName("상품 이름 길이 검증")
    void validateGiftNameLength() {
        Assertions.assertThatThrownBy(() -> GiftsInputView.getGiftNames("123456,abc", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    @DisplayName("상품 이름 개수 검증")
    void validateGiftNameLength(int count) {
        Assertions.assertThatThrownBy(() -> GiftsInputView.getGiftNames("12345,abc,10", count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 이름이 너무 많거나 너무 적습니다.");
    }
}
