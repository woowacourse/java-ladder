package ladder.client.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class InputViewTest {

    @Test
    void 높이를_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("5"));
        assertThat(inputView.inputHeight())
                .isEqualTo(5);
    }

    @Test
    void 높이가_숫자가_아니면_예외() {
        InputView inputView = new InputView(mockInputValue("a"));
        assertThatThrownBy(inputView::inputHeight)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다. 현재 : a");
    }

    @Test
    void 플레이어_이름을_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a,b,c"));
        assertThat(inputView.inputPlayerNames())
                .containsExactly("a", "b", "c");
    }

    @Test
    void 결과_이름들을_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a,b,c"));
        assertThat(inputView.inputResultItems())
                .containsExactly("a", "b", "c");
    }

    @Test
    void 보고싶은_결과를_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a"));
        assertThat(inputView.inputPlayerResult())
                .isEqualTo("a");
    }

    Scanner mockInputValue(String expected) {
        return new Scanner(expected);
    }
}
