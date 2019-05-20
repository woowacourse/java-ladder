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

    @Test
    void 모든_실행_결과_이름이_String_형태로_잘_들어가는지() {
        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("two"));
        goals.add(new LadderGoal("three"));

        assertThat(new LadderGameGoals(goals).getAllGoalNames().get(0).getGoalName()).isEqualTo("one");
        assertThat(new LadderGameGoals(goals).getAllGoalNames().get(1).getGoalName()).isEqualTo("two");
        assertThat(new LadderGameGoals(goals).getAllGoalNames().get(2).getGoalName()).isEqualTo("three");
    }
}