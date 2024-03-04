import domain.Ladder;
import domain.Line;
import domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomLineGenerator;
import util.generator.RandomLineGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private static final RandomLineGenerator randomLineGenerator = new RandomLineGenerator();

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThat(Ladder.of(5, 4, randomLineGenerator).getLines().size()).isEqualTo(5);
    }

    @DisplayName("주어진 너비에 맞게 사다리의 다리의 개수를 생성한다.")
    @Test
    void makeLinesWithWidth() {
        Ladder ladder = Ladder.of(5, 4, randomLineGenerator);
        Line line = ladder.getLines().get(0);

        assertThat(line.getFarRightPosition().getIndex()).isEqualTo(4);
    }

    @DisplayName("주어진 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climb() {
        Ladder ladder = Ladder.of(5, 4, new CustomLineGenerator());

        assertThat(ladder.climb(new Position(1)).getIndex()).isEqualTo(0);
        assertThat(ladder.climb(new Position(2)).getIndex()).isEqualTo(3);
    }

    @DisplayName("맨 왼쪽에 위치한 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climbWithLeftPlayer() {
        Ladder ladder = Ladder.of(5, 4, new CustomLineGenerator());

        assertThat(ladder.climb(new Position(0)).getIndex()).isEqualTo(1);
    }

    @DisplayName("맨 오른쪽에 위치한 참여자의 사다리 타기 결과를 인덱스로 반환한다.")
    @Test
    void climbWithRightPlayer() {
        Ladder ladder = Ladder.of(5, 4, new CustomLineGenerator());

        assertThat(ladder.climb(new Position(3)).getIndex()).isEqualTo(2);
    }
}
