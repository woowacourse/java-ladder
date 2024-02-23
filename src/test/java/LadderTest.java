import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    private static final int HEIGHT = 5;
    private static final int WIDTH = 4;

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThatCode(()->Ladder.from(HEIGHT,WIDTH))
                .doesNotThrowAnyException();
    }

    @DisplayName("주어진 너비에 맞게 사다리의 다리의 개수를 생성한다.")
    @Test
    void makeLinesWithWidth() {
        Ladder ladder = Ladder.from(HEIGHT, WIDTH);

        ladder.getLines().stream()
                        .forEach(line -> assertThat(line.getLegs().size()).isEqualTo(WIDTH));
    }
}
