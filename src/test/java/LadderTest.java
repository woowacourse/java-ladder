import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.generator.RandomBooleanGenerator;
import util.generator.RandomLineGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private static final int HEIGHT = 5;
    private static final int WIDTH = 4;
    private static final RandomLineGenerator randomLineGenerator = new RandomLineGenerator();

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThat(Ladder.from(HEIGHT, WIDTH, randomLineGenerator).getLines().size()).isEqualTo(HEIGHT);
    }

    @DisplayName("주어진 너비에 맞게 사다리의 다리의 개수를 생성한다.")
    @Test
    void makeLinesWithWidth() {
        Ladder ladder = Ladder.from(HEIGHT, WIDTH, randomLineGenerator);

        ladder.getLines().stream()
                .forEach(line -> assertThat(line.getLegs().size()).isEqualTo(WIDTH));
    }
}
