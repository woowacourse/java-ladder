package ladder.domain.ladder;

import ladder.domain.rule.RandomPointLadderRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineGeneratorTest {
    @Test
    public void 길이1이하라인생성불가() {
        assertThrows(IllegalArgumentException.class, () -> {
            LineGenerator.generate(1, new RandomPointLadderRule());
        });
    }

    @Test
    public void 라인한줄생성_강제True주입() {
        Line line = LineGenerator.generate(4, new ForcedTrueRule());
        List<PointDTO> expectResult = Arrays.asList(
                new PointDTO(true), new PointDTO(false), new PointDTO(true), new PointDTO(false)
        );
        assertThat(line.getPointDTO()).isEqualTo(expectResult);
    }

    @Test
    public void 라인한줄생성_강제False주입() {
        Line line = LineGenerator.generate(4, new ForcedFalseRule());
        List<PointDTO> expectResult = Arrays.asList(
                new PointDTO(false), new PointDTO(false), new PointDTO(false), new PointDTO(false)
        );
        assertThat(line.getPointDTO()).isEqualTo(expectResult);
    }
}