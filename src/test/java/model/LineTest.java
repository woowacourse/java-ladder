package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Line 객체 생성 성공 테스트")
    void createLineTest() {
        assertThatNoException().isThrownBy(()->{Line line = new Line(4);});
    }
}
