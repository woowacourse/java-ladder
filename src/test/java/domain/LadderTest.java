package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class LadderTest {

    @Test
    @DisplayName("도메인 생성 성공: 사다리 높이 만큼의 Line 객체 리스트 생성")
    void test_ok_createLines() {
        Ladder ladder = Ladder.of(5, 4, new RandomConnectionStrategy());
        assertThat(ladder.getLines()).hasSize(5);
    }
}
