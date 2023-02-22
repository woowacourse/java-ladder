package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StartIndexTest {

    @Test
    @DisplayName("시작 위치를 받아서 객체가 생성된다.")
    void generateTest() {
        Assertions.assertDoesNotThrow(() -> new StartIndex(1));
    }
}
