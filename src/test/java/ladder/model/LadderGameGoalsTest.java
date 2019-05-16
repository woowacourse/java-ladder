package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameGoalsTest {
    @Test
    void 실행_결과_이름_길이의_최대값_테스트() {
        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("two"));
        goals.add(new LadderGoal("three"));
        assertThat(new LadderGameGoals(goals).getMaxLenOfGoalNames()).isEqualTo(5);
    }
}