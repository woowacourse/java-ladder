package game;

import static org.assertj.core.api.Assertions.assertThat;

import generator.BooleanGenerator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;
import view.Reader;

class LadderGameTest {

    OutputView outputView;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        out.reset();
        System.setOut(new PrintStream(out));
        outputView = new OutputView();
    }

    InputView createInputView(String... inputs) {
        Iterator<String> iterator = Arrays.stream(inputs).iterator();
        Reader reader = iterator::next;
        return new InputView(reader);
    }

    @Test
    @DisplayName("올바른 입력인 경우, 올바르게 작동 후 종료한다.")
    void validGameTest() {
        InputView inputView = createInputView("a,b,c", "2");
        OutputView outputView = new OutputView();
        BooleanGenerator generator = () -> false;
        LadderGame ladderGame = new LadderGame(inputView, outputView, generator);
        ladderGame.play();

        assertThat(out.toString())
                .containsSubsequence(
                        "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
                        "최대 사다리 높이는 몇 개인가요?",
                        "실행결과",
                        "a", "b", "c",
                        "|", "|", "|",
                        "|", "|", "|"
                );
    }
}
