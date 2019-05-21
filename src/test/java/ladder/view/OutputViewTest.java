package ladder.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    @Test
    void 사다리_라인_출력() {
        assertThat(OutputView.makeLine(Arrays.asList(false, true, false, true, false))).isEqualTo("     |-----|     |-----|\n");
    }

    @Test
    void 이름_결과_출력() {
        assertThat(OutputView.makeOutput(Arrays.asList("pobi","brown"))).isEqualTo("  pobi brown");
        assertThat(OutputView.makeOutput(Arrays.asList("꽝","당첨"))).isEqualTo("     꽝    당첨");
    }

}
