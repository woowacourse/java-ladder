package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ladder.domain.generator.DirectionGenerator;
import ladder.domain.generator.TestDirectionGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("사다리 결과를 생성한다.")
    void generateResult() {
        //given
        final Players players = Players.from(List.of("pobi", "crong"));
        final Height height = new Height(2);
        final Prizes prizes = Prizes.from(List.of("꽝", "3000"));
        final DirectionGenerator directionGenerator = new TestDirectionGenerator(Lists.newArrayList(RIGHT, STAY));
        final Ladder ladder = Ladder.of(directionGenerator, players, height);

        //when
        final Result result = Result.of(players, ladder, prizes);

        //then
        Map<String, String> value = result.getValue();
        assertThat(value.get("pobi")).isEqualTo("3000");
        assertThat(value.get("crong")).isEqualTo("꽝");
    }
}

class Result {

    private final Map<String, String> value;

    public Result(final Map<String, String> value) {
        this.value = value;
    }

    public static Result of(final Players players, final Ladder ladder, final Prizes prizes) {
        final Map<String, String> result = new LinkedHashMap<>();
        final List<String> playerNames = players.getPlayerNames();

        for (int position = 0; position < playerNames.size(); position++) {
            final int prizePosition = ladder.climb(position);
            result.put(playerNames.get(position), prizes.check(prizePosition));
        }
        return new Result(result);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(value);
    }
}
