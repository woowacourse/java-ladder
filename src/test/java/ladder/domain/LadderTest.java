package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.linegenerator.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이를 알 수 있다")
    void getHeightTest() {
        LineGenerator lineGenerator = size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = new Ladder(new Height(3), 2, lineGenerator);

        int actual = ladder.getHeight();

        assertThat(actual).isEqualTo(3);
    }
}