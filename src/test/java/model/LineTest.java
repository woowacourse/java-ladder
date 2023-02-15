package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("Line 객체 생성 성공 테스트")
    void createLineTest(){
        Assertions.assertThatNoException().isThrownBy(()->{new Line(5);});
    }
}
