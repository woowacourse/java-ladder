package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class NameTest {
    @Test
    @DisplayName("이름을 받아서 검증 후 Name을 생성한다.")
    void generateTest() {
        String name = "pobi";
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }
}
