package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GoalTest {
    @ParameterizedTest(name = "Goal 객체 name ={0} 생성 성공 테스트")
    @ValueSource(strings = {"pobi", "honux", "crong"})
    void createGoalTest(String input) {
        Assertions.assertThatNoException().isThrownBy(() -> new Goal(input));
    }
}
