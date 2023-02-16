package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNamesTest {

    @Test
    @DisplayName("참여자의 이름이 1자 이상 5자 이하가 아니면 예외를 던진다.")
    void validateLengthTest() {
        List<String> names = List.of("pobiss", "crong");

        assertThrows(IllegalArgumentException.class, () -> new PlayerNames(names))
                .getMessage()
                .equals("[ERROR] 참여자의 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("참여자의 이름이 빈 값이면 예외를 던진다.")
    void validateBlankTest(String name) {

        List<String> names = List.of(name, "pobi");

        assertThrows(IllegalArgumentException.class, () -> new PlayerNames(names))
                .getMessage()
                .equals("[ERROR] 참여자의 이름은 빈 값일 수 없습니다.");
    }
}
