package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private static final Direction directionRight = Direction.createFirst(() -> Bar.TRUE);
    private static final Direction directionLeft = directionRight.createNext(() -> Bar.FALSE);
    private static final Direction directionMiddle = directionLeft.createNext(() -> Bar.FALSE);
    
    @Test
    @DisplayName("라인 생성 시, 랜덤으로 생성되는 Bar가 true인 경우 Line의 각 Direction이 false,true,false,true 여야 한다.")
    void createLineTrue() {
        // given
        Line line = new Line(() -> Bar.TRUE, 4);
        
        // when
        List<Direction> directions = line.getLine();
        
        // then
        assertThat(directions).containsExactly(directionRight, directionLeft, directionRight, directionLeft);
    }
    
    @Test
    @DisplayName("라인 생성 시, 랜덤으로 생성되는 Bar가 false인 경우 Line의 각 Direction이 false,false,false,false 여야 한다.")
    void createLineFalse() {
        // given
        Line line = new Line(() -> Bar.FALSE, 4);
        
        // when
        List<Direction> directions = line.getLine();
        
        // then
        assertThat(directions).containsExactly(directionMiddle, directionMiddle, directionMiddle, directionMiddle);
    }
    
    @Test
    @DisplayName("포지션 목록이 한 라인을 탈 때, 조정된 포지션 목록으로 반환한다.")
    void movedPositions() {
        // given
        Line line = new Line(() -> Bar.TRUE, 4);
        
        // when
        List<Integer> positions = line.getMovedPositions(List.of(0,1,2,3));
        
        // then
        assertThat(positions).containsExactly(1,0,3,2);
    }
}
