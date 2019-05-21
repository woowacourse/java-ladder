package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    List<Boolean> userSetCroossbar;
    List<ResultItem> resultItems;

    @BeforeEach
    void setUp() {
        userSetCroossbar = Arrays.asList(false, true, false);
        resultItems = Arrays.asList(new ResultItem("a"), new ResultItem("b"));
    }

    @Test
    void Ladder가_제대로_생성되는지_테스트() {
        assertThat(new Ladder(3, new UserSetLadderRowGenerator(userSetCroossbar), 2))
                .isEqualTo(new Ladder(3, new UserSetLadderRowGenerator(userSetCroossbar), 2));
    }

    @Test
    void Ladder의_높이가_1보다_작을_때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, new RandomLadderRowGenerator(), 2));
    }

    @Test
    void 사다리의_결과가_담긴_List를_리턴하는지_테스트() {
        Ladder testLadder = new Ladder(1, new UserSetLadderRowGenerator(userSetCroossbar), 2);
        List<Integer> resultItemsIndex = Arrays.asList(1,0);
        assertThat(testLadder.getLadderingResultItemsIndex(2)).isEqualTo(resultItemsIndex);
    }
}
