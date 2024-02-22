import domain.*;
import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WoodWorkMachineTest {
    public static final Point EXIST_POINT = new Point(Step.EXIST);
    public static final Point EMPTY_POINT = new Point(Step.EMPTY);

    @DisplayName("기둥에 발판이 있으면 연결된 다음 기둥에는 발판이 없어야하고, 마지막 다리는 발판이 없다.")
    @Test
    void makeLineExist() {
        // given
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), new TrueGenerator());

        // when & then
        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(EXIST_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    @DisplayName("모든 기둥에 발판이 없는 경우를 확인한다.")
    @Test
    void makeLineEmpty() {
        // given
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), new FalseBooleanGenerator());

        // when & then
        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(EMPTY_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    private static class FalseBooleanGenerator implements BooleanGenerator {
        @Override
        public boolean generate() {
            return false;
        }
    }
}
