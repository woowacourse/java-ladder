package domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 26.
 */
class PlayerTest {

    @DisplayName("이름은 1글자 이상, 5글자 이하여야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "", "evaevv"})
    void validateNameLengthTest(String playerName) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Player(playerName);
        });
    }

}