package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    Crosspoints crosspoints1;
    Crosspoints crosspoints2;
    List<Boolean> userSetCroossbar;
    List<ResultItem> resultItems;

    @BeforeEach
    void setUp() {
        crosspoints1 = new Crosspoints(new Crossbar(Arrays.asList(false, false)));
        crosspoints2 = new Crosspoints(new Crossbar(Arrays.asList(false, true, false)));
        userSetCroossbar = Arrays.asList(false, true, false);
        resultItems = Arrays.asList(new ResultItem("a"), new ResultItem("b"));
    }

    @Test
    void Ladder가_제대로_생성되는지_테스트() {
        assertThat(new Ladder(3, resultItems, new UserSetCrossbarGenerator(userSetCroossbar)))
                .isEqualTo(new Ladder(3, resultItems, new UserSetCrossbarGenerator(userSetCroossbar)));
    }

    @Test
    void Ladder의_높이가_1보다_작을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, resultItems, new RandomCrossbarGenerator(4)));
    }

    @Test
    void 플레이어_위치를_입력받아_결과를_제대로_알려주는지_테스트() {
        Ladder testLadder = new Ladder(1, resultItems,
                new UserSetCrossbarGenerator(userSetCroossbar));

        assertThat(testLadder.answerResult(0)).isEqualTo(new ResultItem("b"));
        assertThat(testLadder.answerResult(1)).isEqualTo(new ResultItem("a"));
    }
}
