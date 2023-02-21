package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"seong,0", "io,1", "odo,2", "jay,3"})
    @DisplayName("이름과 시작 인덱스로 참여자가 생성된다.")
    void generatePlayerTest(String name, int startIndex) {
        Assertions.assertDoesNotThrow(() -> new Player(new Name(name), startIndex));
    }
}
