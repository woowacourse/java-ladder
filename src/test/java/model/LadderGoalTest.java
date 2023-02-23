package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderGoalTest {

    @Test
    @DisplayName("사다리 실행 결과 객체 생성 성공 테스트")
    void createLadderGoalTest() {
        Assertions.assertThatNoException().isThrownBy(
                () -> new LadderGoal("꽝,5000,꽝,3000", 4)
        );
    }

    @ParameterizedTest(name = "사다리 실행 결과 객체 생성 name = {0} 실패 테스트")
    @ValueSource(strings = {"꽝.꽝.꽝.꽝", "꽝,5000,꽝", "100"})
    void createLadderGoalFailTest(String result) {
        Assertions.assertThatThrownBy(
                () -> new LadderGoal(result, 4)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "사다리 실행 결과 객체 생성 name = {0} 실패 테스트")
    @NullAndEmptySource
    void createLadderGoalFailTest2(String result) {
        Assertions.assertThatThrownBy(
                () -> new LadderGoal(result, 4)
        ).isInstanceOf(Exception.class);
    }
}
