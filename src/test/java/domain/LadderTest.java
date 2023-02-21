package domain;


import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderHeight;
import domain.ladder.LineGenerator;
import domain.player.Name;
import domain.player.Player;
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

        // when
        String actualResult = ladder.play(new Player(new Name("name")), position);

        // then
        assertThat(actualResult).isEqualTo(expectResult);
    }

    private Ladder createLadder() {
        LadderGenerator ladderGenerator = new LadderGenerator(
                new LineGenerator(new MockNumberGenerator()));
        List<String> results = List.of("꽝", "3000", "5000", "1000", "2000");
        return ladderGenerator.generate(5, new LadderHeight(4), results);
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
