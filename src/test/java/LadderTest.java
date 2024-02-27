import domain.Ladder;
import domain.Leg;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomLineGenerator;
import util.generator.LineGenerator;
import util.generator.RandomLineGenerator;

import java.util.List;

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

    @DisplayName("주어진 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climb() {
        Ladder ladder = Ladder.from(HEIGHT, WIDTH, new CustomLineGenerator());

        assertThat(ladder.climb(1)).isEqualTo(0);
        assertThat(ladder.climb(2)).isEqualTo(3);
    }

    @DisplayName("맨 왼쪽에 위치한 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climbWithLeftPlayer() {
        Ladder ladder = Ladder.from(HEIGHT, WIDTH, new CustomLineGenerator());

        assertThat(ladder.climb(0)).isEqualTo(1);
    }

    @DisplayName("맨 오른쪽에 위치한 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climbWithRightPlayer() {
        Ladder ladder = Ladder.from(HEIGHT, WIDTH, new CustomLineGenerator());

        assertThat(ladder.climb(3)).isEqualTo(2);
    }
}
