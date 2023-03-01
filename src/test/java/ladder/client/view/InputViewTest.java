package ladder.client.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(ReplaceUnderscores.class)
class InputViewTest {

    private final ByteArrayOutputStream printResult = new ByteArrayOutputStream();

    @BeforeEach
    void setSystemOut() {
        printResult.reset();
        System.setOut(new PrintStream(printResult));
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(System.out);
    }

    @Test
    void 높이를_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("5"));
        assertAll(
                () -> assertThat(inputView.inputHeight())
                        .isEqualTo(5),
                () -> assertThat(printResult)
                        .hasToString("최대 사다리 높이는 몇 개인가요?" + System.lineSeparator()));
    }

    @Test
    void 높이가_숫자가_아니면_예외() {
        InputView inputView = new InputView(mockInputValue("a"));
        assertAll(
                () -> assertThatThrownBy(inputView::inputHeight)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자만 입력 가능합니다. 현재 : a"),
                () -> assertThat(printResult)
                        .hasToString("최대 사다리 높이는 몇 개인가요?" + System.lineSeparator()));
    }

    @Test
    void 플레이어_이름을_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a,b,c"));
        assertAll(
                () -> assertThat(inputView.inputPlayerNames())
                        .containsExactly("a", "b", "c"),
                () -> assertThat(printResult)
                        .hasToString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)" + System.lineSeparator()));
    }

    @Test
    void 결과_이름들을_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a,b,c"));
        assertAll(
                () -> assertThat(inputView.inputResultNames())
                        .containsExactly("a", "b", "c"),
                () -> assertThat(printResult)
                        .hasToString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)" + System.lineSeparator()));
    }

    @Test
    void 보고싶은_결과를_읽어오는_테스트() {
        InputView inputView = new InputView(mockInputValue("a"));
        assertAll(
                () -> assertThat(inputView.inputPlayerResult())
                        .isEqualTo("a"),
                () -> assertThat(printResult)
                        .hasToString("결과를 보고 싶은 사람은?" + System.lineSeparator()));
    }

    private Scanner mockInputValue(String expected) {
        return new Scanner(expected);
    }
}
