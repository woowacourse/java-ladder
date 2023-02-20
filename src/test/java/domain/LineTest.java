package domain;

import domain.util.PointGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("연속하지 않는 다리로 생성된 라인 포맷을 반환해야한다.")
    void lineFormatSuccessTest() {
        LadderWidth ladderWidth = new LadderWidth(5);
        String lineFormat = Line.create(ladderWidth, PointGenerator.getInstance(false)).format();
        Assertions.assertThat(lineFormat).isEqualTo("     |-----|     |-----|     |-----|");
    }

}