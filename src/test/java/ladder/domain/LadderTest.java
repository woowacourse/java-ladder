package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.strategy.linestrategy.CustomLineStrategy;
import ladder.domain.strategy.linestrategy.LineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

class LadderTest {
    private Players players;
    private Ladder ladder;

    @BeforeEach
    void beforeEach() {
        players = new Players(new String[]{"a", "b", "c", "d"});
        ladder = generateCustomLadder(players);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:3", "1:2", "2:1", "3:0"}, delimiter = ':')
    @DisplayName("올바른 결과에 해당하는 position을 반환한다.")
    void moveToResultTest_success(int startPosition, int resultPosition) {
        // when
        int expect = ladder.moveToResult(startPosition);

        // then
        assertThat(expect).isEqualTo(resultPosition);
    }

    private Ladder generateCustomLadder(Players players) {
        Height height = new Height(4);
        LineStrategy lineStrategy = new CustomLineStrategy(List.of(Step.EXIST, Step.EMPTY));
        LadderFactory ladderFactory = new LadderFactory(height, players, lineStrategy);
        return ladderFactory.makeLadder();
    }
}
