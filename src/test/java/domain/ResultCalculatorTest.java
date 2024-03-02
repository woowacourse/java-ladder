package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.generator.FixedBridgeGenerator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {

    @DisplayName("생성된 Ladder을 바탕으로 결과를 계산한다")
    @Test
    public void calculateTest() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Level level = new Level(0);
        Line line = new Line(4, new FixedBridgeGenerator());
        Map<Level, Line> lines = Map.of(level, line);

        Result result = ResultCalculator.calculate(players, lines);

        assertThat(result.matchAll(prizes)).isEqualTo(Map.of(
                "pobi", "5000",
                "honux", "꽝",
                "crong", "3000",
                "jk", "꽝"));
    }
}
