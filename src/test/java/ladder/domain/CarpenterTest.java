package ladder.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarpenterTest {

    @DisplayName("목수의 체력이 6이상일 경우 사다리에 다리를 놓는다.")
    @Test
    void buildStepTest() {
        Height height = new Height("5");
        Carpenter carpenter = new Carpenter(height, () -> 6, 5);

        List<Ladder> ladders = carpenter.getLadders();
        Ladder ladder = ladders.get(1);

        carpenter.buildLadder(ladder, 2);

        List<Boolean> steps = ladders.get(1).getSteps();
        Assertions.assertThat(steps.get(2)).isTrue();
    }

    @DisplayName("목수가 체력이 5 이하일 경우 사다리에 다리를 놓는다.")
    @Test
    void notBuildStepTest() {
        Height height = new Height("5");
        Carpenter carpenter = new Carpenter(height, () -> 5, 5);

        List<Ladder> ladders = carpenter.getLadders();
        Ladder ladder = ladders.get(1);

        carpenter.buildLadder(ladder, 2);

        List<Boolean> steps = ladders.get(1).getSteps();
        Assertions.assertThat(steps.get(2)).isFalse();
    }

    @DisplayName("목수가 가지고 있는 사다리를 짓는다.")
    @Test
    void buildLaddersTest() {
        Height height = new Height("4");
        Carpenter carpenter = new Carpenter(height, () -> 6, 7);

        List<Ladder> ladders = carpenter.getLadders();
        carpenter.buildLadders(7);
    }
}
