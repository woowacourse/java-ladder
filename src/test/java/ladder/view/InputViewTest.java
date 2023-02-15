package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private final InputView inputView = InputView.getInstance();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("입력받은 문자열을 ,를 기준으로 잘 분리하는지 테스트")
    void splitNameTest(){
        String input = "이오,이리내,깃짱,성하\n";
        InputStream in = generateUserInput(input);
        System.setIn(in);

        assertThat(inputView.readNames().size()).isEqualTo(4);

    }
}