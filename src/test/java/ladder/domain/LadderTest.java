package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    private Crosspoint rightHandCrosspoint;
    private Crosspoint leftHandCrosspoint;
    private Crosspoint downwardCrosspoint;

    @BeforeEach
    void setUp() {
        rightHandCrosspoint = new Crosspoint(false, true);
        leftHandCrosspoint = new Crosspoint(true, false);
        downwardCrosspoint = new Crosspoint(false, false);
    }

    @Test
    void Ladder의_높이가_1보다_작을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 1));
    }

    @Test
    void Ladder의_너비가_1보다_작을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(1,
                Arrays.asList(new LadderRow(Arrays.asList(downwardCrosspoint)))));
    }

    @Test
    void 플레이어_위치를_입력받아_결과를_제대로_알려주는지_테스트() {
        Ladder testLadder = new Ladder(1,
                Arrays.asList(new LadderRow(Arrays.asList(rightHandCrosspoint, leftHandCrosspoint))));
                                //  이렇게 생긴 사다리 :  |-----|

        assertThat(testLadder.answerResultPositionOf(0)).isEqualTo(1);
    }
}
