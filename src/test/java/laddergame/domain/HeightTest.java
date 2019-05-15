package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeightTest {
    Height height;

    @BeforeEach
    void setUp() {

    }

    @Test
    void 최대_높이_입력_테스트() {
        height = new Height(4);
        assertThat(height).isEqualTo(new Height(4));
    }

    /*@Test
    void 높이*/
}
