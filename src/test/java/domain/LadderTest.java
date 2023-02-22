package domain;


import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.ladder.LineGenerator;
import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.NumberGenerator;

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
        Ladder ladder = createLadder();
        Player player = new Player(new Name("hs"), new Position(position));

        // when
        LadderResult ladderResult = ladder.play(player);

        // then
        assertThat(ladderResult.getResult()).isEqualTo(expectResult);
    }

    private Ladder createLadder() {
        LadderGenerator ladderGenerator = new LadderGenerator(
                new LineGenerator(new MockNumberGenerator()));
        int numberOfPeople = 5;
        LadderResults ladderResults = createLadderResults(numberOfPeople, "꽝", "3000", "5000", "1000", "2000");
        return ladderGenerator.generate(numberOfPeople, new LadderHeight(4), ladderResults);
    }

    private LadderResults createLadderResults(int numberOfPeople,
                                              String... result) {
        List<LadderResult> ladderResults = Arrays.stream(result)
                .map(LadderResult::new)
                .collect(toList());
        return LadderResults.createByPlayersSize(ladderResults, numberOfPeople);
    }

    static class MockNumberGenerator implements NumberGenerator {

        private final List<Integer> list = List.of(3, 4, 4);
        private int index = 0;

        @Override
        public int generate() {
            return list.get((++index) % list.size());
        }
    }
}
