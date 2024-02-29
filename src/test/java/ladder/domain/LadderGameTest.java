package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임")
public class LadderGameTest {
    private static final Ladder FIXED_LADDER = new Ladder(List.of(
            new Line(List.of(Connection.RUNG, Connection.EMPTY, Connection.RUNG)), // |-----|     |-----|
            new Line(List.of(Connection.EMPTY, Connection.RUNG, Connection.EMPTY)) // |     |-----|     |
    ));
    private static final LadderCreator FIXED_LADDER_CREATOR = new LadderCreator() {
        @Override
        public Ladder create(int width, int height) {
            return FIXED_LADDER;
        }
    };

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
        LadderGame ladderGame = new LadderGame(FIXED_LADDER_CREATOR);

        Ladder expected = new Ladder(List.of(
                new Line(List.of(Connection.EMPTY)),
                new Line(List.of(Connection.EMPTY))));

        // when
        Ladder ladder = ladderGame.processGame(people, ladderHeight);

        // then
        assertThat(ladder)
                .usingRecursiveComparison()
                .isEqualTo(FIXED_LADDER);
    }

    @DisplayName("사다리 타기 전체 결과를 구한다.")
    @Test
    void findTotalResultTest() {
        // given
        LadderGame ladderGame = new LadderGame(FIXED_LADDER_CREATOR);
        People people = new People(List.of(
                new Person("pobi"), new Person("neo"), new Person("kaki"), new Person("lisa")));
        List<String> winningResults = List.of(
                "1등", "2등", "3등", "4등");
        Map<String, String> expected = Map.of(
                "pobi", "3등",
                "neo", "1등",
                "kaki", "4등",
                "lisa", "2등"
        );

        // when & then
        assertThat(ladderGame.findResult(FIXED_LADDER, people, winningResults))
                .isEqualTo(expected);
    }
}
