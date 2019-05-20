package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 높이에_따른_라인_개수() {
        String[] names = {"denis", "pobi", "whale", "G-ONL"};
        Ladder ladder = new Ladder(names.length, 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
