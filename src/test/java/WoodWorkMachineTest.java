import domain.*;
import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WoodWorkMachineTest {
    @DisplayName("앞에 다리가 생성되었을 때 연결된 다음 다리를 생성하지 않는지 테스트")
    @Test
    void makeLineExist() {
        final BooleanGenerator trueGenerator = new TrueGenerator();
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), trueGenerator);
        final Point point = new Point(Step.EXIST);
        final Point falsePoint = new Point(Step.EMPTY);

        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(point, falsePoint, falsePoint)));
    }

    @DisplayName("모든 다리의 Point가 발판을 가지지 않는 경우 테스트")
    @Test
    void makeLineEmpty() {
        final BooleanGenerator falseBooleanGenerator = new FalseBooleanGenerator();
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), falseBooleanGenerator);
        final Point falsePoint = new Point(Step.EMPTY);

        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(falsePoint, falsePoint, falsePoint)));
    }

    private static class FalseBooleanGenerator implements BooleanGenerator {

        @Override
        public boolean generate() {
            return false;
        }
    }


}
