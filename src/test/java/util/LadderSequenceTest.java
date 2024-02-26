package util;

import domain.CustomGenerator;
import domain.Height;
import domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderSequenceTest {

    @DisplayName("Ladder의 상태를 String으로 반환한다.")
    @Test
    void LadderToStringTest() {
        Ladder ladder = new Ladder(new Height(5));
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true, false, true, false));
        ladder.init(5, customGenerator);
        Assertions.assertThat(LadderSequence.from(ladder))
                .isEqualTo(List.of(
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |"
                ));
    }
}
