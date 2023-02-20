package model;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    @DisplayName("Result 객체 생성 성공 테스트")
    void createResultTest() {
        assertThatNoException().isThrownBy(() -> new Result("10000"));
    }
}
