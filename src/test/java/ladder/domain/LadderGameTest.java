package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    @Test
    void 쉼표로_문자열_구분하기() {
        assertThat(LadderGame.splitNames("pobi,honux,crong,jk")).isEqualTo(Arrays.asList("pobi","honux","crong","jk"));
    }
}
