package ladder.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    private final InputView inputView = InputView.getInstance();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력받은 문자열을 ,를 기준으로 잘 분리하는지 테스트")
    void splitNameTest() {
        String input = "이오,이리내,깃짱,성하\n";
        InputStream in = generateUserInput(input);
        System.setIn(in);

        assertThat(inputView.readNames().size()).isEqualTo(4);

    }

    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외 처리 테스트")
    void duplicateNameTest() {
        String input = "이오,이리내,깃짱,성하,이오\n";
        InputStream in = generateUserInput(input);
        System.setIn(in);

        Assertions.assertThatThrownBy(inputView::readNames)
                .isInstanceOf(IllegalArgumentException.class);
    }


}