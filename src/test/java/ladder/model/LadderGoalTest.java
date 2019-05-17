package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGoalTest {
    @Test
    void 객체에_Goal_이름이_잘_입력되었는지_테스트() {
        assertThat(new LadderGoal("one").getGoalName()).isEqualTo("one");
    }

    @Test
    void 이름이_없거나_빈칸인_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGoal(" ");
        });
    }

    @Test
    void 정렬된_이름을_가져오는_메소드_테스트() {
        assertEquals(new LadderGoal("one").getAlignedGoalName(), "one   ");
        assertEquals(new LadderGoal("three").getAlignedGoalName(), "three ");
    }
}
