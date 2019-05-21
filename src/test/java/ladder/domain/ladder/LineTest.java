package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 라인너비초기화() {
        assertThat(LineGenerator.generate(3, new RandomPointLadderRule()).getPointDTO().size()).isEqualTo(3);
    }

    @Test
    public void 다음포인트인덱스얻기1() {
        Line line = LineGenerator.generate(5, new ForcedTrueRule());
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    public void 다음포인트인덱스얻기2() {
        Line line = LineGenerator.generate(5, new ForcedFalseRule());
        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
    }
}

class ForcedTrueRule implements LadderRule {
    @Override
    public boolean isAvailablePoint() {
        return true;
    }
}

class ForcedFalseRule implements LadderRule {
    @Override
    public boolean isAvailablePoint() {
        return false;
    }
}