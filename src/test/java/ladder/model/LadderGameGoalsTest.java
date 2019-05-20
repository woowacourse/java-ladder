package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameGoalsTest {
    @Test
    void 모든_실행결과의_이름들을_추출하는_메소드_테스트() {
        List<LadderGoal> goals = new ArrayList<>(Arrays.asList(new LadderGoal("one")
                , new LadderGoal("two"), new LadderGoal("three")));

        List<String> goalNames = new LadderGameGoals(goals, 3).getAllGoalNames();

        assertThat(goalNames.get(0)).isEqualTo("one");
        assertThat(goalNames.get(1)).isEqualTo("two");
        assertThat(goalNames.get(2)).isEqualTo("three");
    }
}