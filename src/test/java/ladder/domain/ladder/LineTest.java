package ladder.domain.ladder;

import ladder.domain.ladder.line.Line;
import ladder.domain.rule.LadderRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 라인너비초기화() {
        int length = 5;
        assertThat(new Line(length, new ForcedTrueRule()).getPoints().size()).isEqualTo(5);
    }

    @Test
    public void 라인한줄생성_강제True주입() {
        Line line = new Line(5, new ForcedTrueRule());
        List<Boolean> testRandomInput = Arrays.asList(true, false, true, false, false);
        assertThat(line.getPoints()).isEqualTo(testRandomInput);
    }

    @Test
    public void 라인한줄생성_강제False주입() {
        Line line = new Line(5, new ForcedFalseRule());
        List<Boolean> testRandomInput = Arrays.asList(false, false, false, false, false);
        assertThat(line.getPoints()).isEqualTo(testRandomInput);
    }

    @Test
    public void 다음포인트인덱스얻기() {
        Line line = new Line(5, new ForcedTrueRule());
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    public void 다음포인트인덱스얻기2() {
        Line line = new Line(5, new ForcedFalseRule());
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