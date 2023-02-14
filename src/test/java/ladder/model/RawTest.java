package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RawTest {


    @Test
    @DisplayName("특정 인덱스에 가로 라인 생성 테스트")
    void createLineTest() {
        int personCount = 5;
        int index = 0;
        Raw raw = new Raw(personCount);
        raw.createLine(index);
        assertThat(raw.isPointHasLine(index)).isTrue();
    }
}