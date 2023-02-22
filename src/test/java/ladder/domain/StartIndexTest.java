package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StartIndexTest {

    @Test
    @DisplayName("시작 위치를 받아서 객체가 생성된다.")
    void generateTest() {
        Assertions.assertDoesNotThrow(() -> new StartIndex(1));
    }

    @Test
    @DisplayName("시작 위치를 반환한다.")
    void getterTest() {
        int initStartIndex = 1;
        StartIndex startIndex = new StartIndex(initStartIndex);

        assertThat(startIndex.getRawStartIndex()).isEqualTo(initStartIndex);
    }
}
