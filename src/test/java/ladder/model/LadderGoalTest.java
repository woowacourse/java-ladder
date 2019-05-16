package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGoalTest {
    @Test
    void 이름이_객체에_잘들어가는_경우() {
        assertThat(new LadderGoal("one").getGoalName()).isEqualTo("one");
    }

    @Test
    void 이름이_없거나_빈칸인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal(" ");
        });
    }
}
