package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "judith"})
    void 플레이어의_생성_실패_테스트(String name) {
        assertThatThrownBy(() -> new Player(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ako", "가가가", "나1가"})
    void 플레이어_생성_성공_테스트(String name) {
        assertDoesNotThrow(() -> new Player(name));
    }
}
