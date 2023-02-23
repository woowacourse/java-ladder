package domain;

import domain.Ladder.LadderWidth;
import domain.Ladder.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderView;

class LineTest {

    @Test
    @DisplayName("연속하지 않는 다리로 생성된 라인 포맷을 반환해야한다.")
    void lineFormatSuccessTest() {
        LadderWidth ladderWidth = LadderWidth.from(5);
        Line line = Line.create(ladderWidth, new FixedPresencePointGenerator());
        Assertions.assertThat(LadderView.formatLine(line)).isEqualTo("     |-----|     |-----|     |-----|");
    }

}