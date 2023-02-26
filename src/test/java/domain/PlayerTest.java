package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import exception.InvalidPlayerNameException;
import exception.NullOrBlankInputException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "  "})
    void 플레이어의_생성_실패_테스트(String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(NullOrBlankInputException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가가가가가가", "beaver"})
    void 플레이어의_이름이_5자보다_크면_생성이_실패한다(String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(InvalidPlayerNameException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ako", "가가가", "나1가"})
    void 플레이어_생성_성공_테스트(String name) {
        assertDoesNotThrow(() -> new Player(name));
    }
}
