package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("Generator로 만들어진 List로 Line을 생성한다.")
    @Test
    void ladderInitTest() {
        Ladder ladder = new Ladder(new Height(1));
        ladder.init(2, new CustomGenerator(List.of(false, true)));
        Assertions.assertThat(ladder.getLadder())
                .isEqualTo(List.of(new Line(List.of(4, 5))));
    }
}
