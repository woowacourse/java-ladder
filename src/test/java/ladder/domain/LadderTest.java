package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
    
    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    @DisplayName("사다리 높이가 1~100 범위를 벗어난 경우 예외가 발생한다.")
    void normalLadderHeight(int ladderHeight) {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(() -> Bar.TRUE, ladderHeight, 0));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    @DisplayName("사다리 높이가 1~100 범위를 벗어난 경우 예외가 발생한다.")
    void ladderHeightOutOfRange(int ladderHeight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(() -> Bar.TRUE, ladderHeight, 0))
                .withMessage("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
    }
}
