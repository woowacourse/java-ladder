package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private static final Direction directionRight = Direction.createFirst(() -> Bar.TRUE);
    private static final Direction directionLeft = directionRight.createNext(() -> Bar.FALSE);
    private static final Direction directionMiddle = directionLeft.createNext(() -> Bar.FALSE);
    
    @Test
    @DisplayName("라인 생성 시, 랜덤으로 생성되는 Bar가 true인 경우 Line의 각 Direction이 false,true,false,true 여야 한다.")
    void createLineTrue() {
        Line line = new Line(() -> Bar.TRUE, 4);
        assertThat(line.getLine()).containsExactly(directionRight, directionLeft, directionRight, directionLeft);
    }
    
    @Test
    @DisplayName("라인 생성 시, 랜덤으로 생성되는 Bar가 false인 경우 Line의 각 Direction이 false,false,false,false 여야 한다.")
    void createLineFalse() {
        Line line = new Line(() -> Bar.FALSE, 4);
        assertThat(line.getLine()).containsExactly(directionMiddle, directionMiddle, directionMiddle, directionMiddle);
    }
}
