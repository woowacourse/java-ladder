import domain.*;
import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WoodWorkMachineTest {

    private static final Point EXIST_POINT = new Point(Step.EXIST);
    private static final Point EMPTY_POINT = new Point(Step.EMPTY);

    @DisplayName("앞에 다리가 생성되면 연결된 다음 다리는 발판이 없어야 하고, 마지막 다리는 발판이 없어야 한다.")
    @Test
    void makeLineExist() {
        //given
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), new TrueGenerator());

        //when & then
        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(EXIST_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    @DisplayName("모든 다리가 발판을 가지지 않는 경우 테스트")
    @Test
    void makeLineEmpty() {
        //given
        final BooleanGenerator falseBooleanGenerator = new FalseBooleanGenerator();
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(PlayerCount.from(3), falseBooleanGenerator);

        //when & then
        assertThat(woodWorkMachine.makeLine()).isEqualTo(new Line(List.of(EMPTY_POINT, EMPTY_POINT, EMPTY_POINT)));
    }

    private static class FalseBooleanGenerator implements BooleanGenerator {

        @Override
        public boolean generate() {
            return false;
        }
    }
}
