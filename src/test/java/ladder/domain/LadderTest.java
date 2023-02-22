package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 높이만큼 라인을 생성한다.")
    void test_1() {
        // given
        Ladder ladder = new Ladder(() -> Bar.TRUE, 5, 4);

        // then
        assertThat(ladder.getLines())
                .hasSize(5);
    }
    
    @Test
    @DisplayName("포지션 목록이 사다리를 탈 때, 조정된 포지션 목록으로 반환한다.")
    void movedPositions() {
        // given
        Ladder ladder = new Ladder(() -> Bar.TRUE, 5, 4);
    
        //when
        List<Integer> positions = ladder.getMovedPositions(4);
        
        // then
        assertThat(positions).containsExactly(1,0,3,2);
    }
}
