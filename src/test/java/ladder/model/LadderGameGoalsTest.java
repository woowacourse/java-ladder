package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameGoalsTest {
    @Test
    void 모든_실행결과의_이름들을_추출하는_메소드_테스트() {
        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("two"));
        goals.add(new LadderGoal("three"));

        List<String> goalNames = new LadderGameGoals(goals).getAllGoalNames();

        assertThat(goalNames.get(0)).isEqualTo("one");
        assertThat(goalNames.get(1)).isEqualTo("two");
        assertThat(goalNames.get(2)).isEqualTo("three");
    }
}