package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임")
public class LadderGameTest {
    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThatCode(() -> new LadderGame(new RandomLadderCreator(new RandomLineCreator())))
                .doesNotThrowAnyException();
    }

    @DisplayName("사람들과 사다리의 높이를 가지고 사다리를 생성한다.")
    @Test
    void createLadderTest() {
        // given
        People people = new People(List.of(new Person("pobi"), new Person("nak")));
        LadderHeight ladderHeight = new LadderHeight(2);
        LadderGame ladderGame = new LadderGame(new FixedLadderCreator());

        Ladder expected = new Ladder(List.of(
                new Line(List.of(Connection.EMPTY)),
                new Line(List.of(Connection.EMPTY))));

        // when
        Ladder ladder = ladderGame.processGame(people, ladderHeight);

        // then
        assertThat(ladder)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    static class FixedLadderCreator implements LadderCreator {
        @Override
        public Ladder create(int width, int height) {
            return new Ladder(IntStream.range(0, height)
                    .mapToObj(i -> createLine(width))
                    .toList());
        }

        private Line createLine(int width) {
            return new Line(new ArrayList<>(Collections.nCopies(width, Connection.EMPTY)));
        }
    }
}
