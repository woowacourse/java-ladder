package ladder.domain;

import ladder.domain.creator.LadderCreator;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import ladder.domain.item.LadderItems;
import ladder.domain.item.People;
import ladder.domain.item.Person;
import ladder.domain.item.WinningItem;
import ladder.domain.item.WinningItems;
import ladder.domain.ladder.Connection;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Line;
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
        LadderItems ladderItems = new LadderItems(
                new People(List.of("pobi", "nak")),
                new WinningItems(List.of("1등", "2등")));
        LadderHeight ladderHeight = new LadderHeight(2);
        LadderGame ladderGame = new LadderGame(FIXED_LADDER_CREATOR);

        Ladder expected = new Ladder(List.of(
                new Line(List.of(Connection.EMPTY)),
                new Line(List.of(Connection.EMPTY))));

        // when
        Ladder ladder = ladderGame.createLadder(ladderItems, ladderHeight);

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
        List<String> peopleNames = List.of("pobi", "neo", "kaki", "lisa");
        List<String> winningItemNames = List.of("1등", "2등", "3등", "4등");

        LadderItems ladderItems = new LadderItems(new People(peopleNames), new WinningItems(winningItemNames));
        Map<Person, WinningItem> expected = Map.of(
                new Person("pobi"), new WinningItem("3등"),
                new Person("neo"), new WinningItem("1등"),
                new Person("kaki"), new WinningItem("4등"),
                new Person("lisa"), new WinningItem("2등")
        );

        // when & then
        assertThat(ladderGame.findResult(FIXED_LADDER, ladderItems))
                .extracting("result")
                .isEqualTo(expected);
    }
}
