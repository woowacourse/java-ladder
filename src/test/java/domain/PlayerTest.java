package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "judith"})
    void 플레이어의_이름_검증(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player(name);
        });
    }
}
