package util;

import domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderStringTest {

    @DisplayName("Ladder의 상태를 String으로 반환한다.")
    @Test
    void LadderToStringTest() {
        Ladder ladder = new Ladder(5);
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true, false, true, false));
        ladder.init(5, customGenerator);
        Assertions.assertThat(LadderString.from(ladder))
                .isEqualTo(List.of(
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |",
                        "     |-----|     |-----|     |"
                ));
    }
}
