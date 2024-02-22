package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomPointStrategy;

public class LinesTest {

    @Test
    @DisplayName("도메인 생성 성공: 사다리 높이 만큼의 Line 객체 리스트 생성")
    void test_ok_createLines() {
        Height height = new Height("5");
        Lines lines = new Lines(4, height, new RandomPointStrategy());
        assertThat(lines.getLines().size()).isEqualTo(5);
    }
}
