package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameGoalsTest {
    @Test
    void 실행결과의_수가_플레이어의_수와_일치하지_않는_경우_테스트() {
        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("two"));
        goals.add(new LadderGoal("three"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGameGoals(goals, 5);
        });
    }

    @Test
    void 중복된_실행결과_이름이_존재하는_경우_테스트() {
        List<LadderGoal> goals = new ArrayList<>();
        goals.add(new LadderGoal("one"));
        goals.add(new LadderGoal("one"));

        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGameGoals(goals, 2);
        });
    }

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