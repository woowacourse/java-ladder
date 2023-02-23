package domain.ladder;


import static domain.ladder.LinePoint.BLOCKED;
import static domain.ladder.LinePoint.PASSABLE;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    /**
     * pobi  neo   me    ohs   hello
     * |-----|     |-----|     |
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     * |     |-----|     |-----|
     * 꽝  3000   5000   1000   2000
     */
    @DisplayName("play()를 통해 게임 결과에 맞는 ladderResult를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:5000", "2:꽝", "3:2000", "4:3000", "5:1000"}, delimiter = ':')
    void move_result_test(int position, String expectResult) {
        // given
        LadderResults ladderResults = createLadderResults(5, "꽝", "3000", "5000", "1000", "2000");
        Ladder ladder = new Ladder(createLine(), ladderResults);
        Player player = new Player(new Name("hs"), new Position(position));

        // when
        LadderResult ladderResult = ladder.play(player);

        // then
        assertThat(ladderResult.getResult()).isEqualTo(expectResult);
    }

    private LadderResults createLadderResults(int numberOfPeople,
                                              String... result) {
        List<LadderResult> ladderResults = Arrays.stream(result)
                .map(LadderResult::new)
                .collect(toList());
        return LadderResults.createByPlayersSize(ladderResults, numberOfPeople);
    }

    private List<Line> createLine() {
        return List.of(
                new Line(List.of(PASSABLE, BLOCKED, PASSABLE, BLOCKED)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)),
                new Line(List.of(BLOCKED, PASSABLE, BLOCKED, PASSABLE)));
    }
}
