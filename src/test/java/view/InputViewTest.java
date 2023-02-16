package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputViewTest {
    InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 플레이어_이름_빈칸_입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> inputView.readPlayerName())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
