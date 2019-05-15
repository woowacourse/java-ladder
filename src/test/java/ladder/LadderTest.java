package ladder;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderTest {
    @Test
    void 쉼표로_문자열_구분하기() {
        assertThat(Ladder.splitNames("pobi,honux,crong,jk")).isEqualTo(Arrays.asList("pobi","honux","crong","jk"));
    }

    @Test
    void 글자수_5자_이하인_경우_True_반환() {
        assertTrue(Ladder.checkNameLength("pobi"));
    }

    @Test
    void 글자수_5자_초과인_경우_False_반환() {
        assertFalse(Ladder.checkNameLength("pobihonux"));
    }

    @Test
    void 사다리_높이값이_숫자인_경우_True_반횐() {
        assertTrue(Ladder.checkLadderHeight("19"));
    }

    @Test
    void 사다리_높이값이_숫자가_아닌_경우_False_반환() {
        assertFalse(Ladder.checkLadderHeight("a"));
    }
}
