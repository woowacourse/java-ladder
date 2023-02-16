package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private InputView inputView;

    @DisplayName("사람 이름에 빈 입력값이 들어온 경우 예외를 발생시킨다.")
    @Test
    void playerNameInputNotEmpty() {
        initInput("\n");
        assertThatThrownBy(() -> inputView.readPlayerNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다")
    @CsvSource(value = {"a,b,c:a:b:c", "a,,:a:'':''"}, delimiter = ':')
    @ParameterizedTest
    void parsePlayerNames(String input, String name1, String name2, String name3) {
        initInput(input);
        List<String> playerNames = inputView.readPlayerNames();
        assertThat(playerNames).containsExactly(name1, name2, name3);
    }

    @DisplayName("사다리 최대 높이 입력값은 정수가 아닌 수가 입력된 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"a", "aaa", "1l", "0.1", "1.5", "1.0"})
    @ParameterizedTest
    void validateLadderHeightNotInteger(String input) {
        initInput(input);
        assertThatThrownBy(() -> inputView.readLadderHeight())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void initInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView(new Scanner(System.in));
    }
}
