package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomPointStrategy;

public class LinesTest {

    @Test
    @DisplayName("사디리 높이에 맞게 Line 리스트 생성 성공")
    void test_ok_createListLine() {
        Lines lines = new Lines(new Height("5"), new RandomPointStrategy());
        assertThat(lines.getLines().size()).isEqualTo(5);
    }
}
