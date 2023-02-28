package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("이름은 1글자 이상, 5글자 이하여야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "", "evaevv"})
    void validateNameLengthTest(String playerName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player(playerName, 1);
        });
    }

}