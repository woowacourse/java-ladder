package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("실행 결과들을 생성한다.")
    void generateTest() {
        Result result1 = new Result(new Reward("꽝", 0));
        Result result2 = new Result(new Reward("5000", 0));

        Assertions.assertDoesNotThrow(() -> new Results(List.of(result1, result2)));
    }

    @Test
    @DisplayName("실행 결과 인덱스로 실행 결과를 찾아서 반환한다.")
    void findResultByRewardIndexTest() {
        Result result1 = new Result(new Reward("꽝", 0));
        Result result2 = new Result(new Reward("5000", 1));

        Results results = new Results(List.of(result1, result2));

        assertThat(results.findResultByRewardIndex(0)).isEqualTo(result1);
        assertThat(results.findResultByRewardIndex(1)).isEqualTo(result2);
    }

    @Test
    @DisplayName("실행 결과 인덱스로 실행 결과를 찾을 때 찾지 못하면 예외를 던진다.")
    void notFindResultByRewardIndexTest() {
        Result result1 = new Result(new Reward("꽝", 0));
        Result result2 = new Result(new Reward("5000", 1));

        Results results = new Results(List.of(result1, result2));

        assertThatThrownBy(() -> results.findResultByRewardIndex(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] Reward Index에 맞는 Result를 찾을 수 없습니다.");
    }
}
