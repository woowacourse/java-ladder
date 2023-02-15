package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
