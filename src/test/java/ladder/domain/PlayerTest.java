package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("참여자의 이름이 1자 이상 5자 이하가 아니면 예외를 던진다.")
    void validateLengthTest() {
        String name = "pobiiiii";

        assertThrows(IllegalArgumentException.class, () -> new Player(name, 0))
                .getMessage()
                .equals("[ERROR] 참여자의 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("참여자의 이름이 빈 값이면 예외를 던진다.")
    void validateBlankTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Player(name, 0))
                .getMessage()
                .equals("[ERROR] 참여자의 이름은 빈 값일 수 없습니다.");
    }
}
