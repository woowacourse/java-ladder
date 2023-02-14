package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RawTest {


    @Test
    @DisplayName("특정 인덱스에 가로 라인 생성 테스트")
    void createLineTest() {
        int personCount = 5;
        int point = 0;
        boolean isCreated = true;
        Raw raw = new Raw(personCount);
        raw.createLineAt(point, isCreated);
        assertThat(raw.isPointHasLine(point)).isTrue();
    }

    @Test
    @DisplayName("왼쪽 포인트에 라인이 존재하면 true를 반환하는 테스트")
    void checkLeftPointHasLineTest() {
        int personCount = 5;
        int point = 1;
        Raw raw = new Raw(personCount);
        raw.createLineAt(point - 1, true);
        assertThat(raw.isLeftPointHasLine(point)).isTrue();

    }


}