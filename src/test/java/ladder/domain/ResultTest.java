package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {

    private Players players;
    private Ladder ladder;
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        players = Players.from(List.of("pobi", "crong"));
        final Height height = new Height(2);
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(Lists.newArrayList(RIGHT, STAY));
        ladder = Ladder.of(directionGenerator, players, height);
        prizes = Prizes.from(List.of("꽝", "3000"));
    }

    @Test
    @DisplayName("사다리 결과를 생성한다.")
    void generateResult() {
        final Result result = Result.of(players, ladder, prizes);

        assertThat(result.extract("pobi")).isEqualTo("3000");
        assertThat(result.extract("crong")).isEqualTo("꽝");
    }

    @ParameterizedTest(name = "입력: {0}, 결과: {1}")
    @CsvSource(value = {"pobi:true", "honux:false"}, delimiter = ':')
    @DisplayName("결과를 확인할 수 있는 대상인지 판별한다.")
    void existResultTarget(final String target, final boolean expected) {
        final Result result = Result.of(players, ladder, prizes);

        assertThat(result.exist(target)).isEqualTo(expected);
    }
}
