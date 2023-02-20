package model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultsTest {
    private static final String WRONG_SIZE_RESULTS_ERROR = "[ERROR] 사다리 게임 결과 값의 개수는 전체 사람의 수와 동일해야 합니다.";

    @Test
    @DisplayName("Results 객체 생성 성공 테스트")
    void createResultsTest() {
        assertThatNoException().isThrownBy(() -> new Results(4, "꽝, 5000, 꽝, 3000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, neo, hiiro", "pobi, neo, hiiro, ocean, kevin"})
    @DisplayName("사다리 게임 결과 값의 수와 전체 사람 수가 같은지 검증 기능 테스트")
    void validateRightResultsSizeTest(String inputNames) {
        //given
        Players players = new Players(new Names(inputNames));

        //then
        assertThatThrownBy(() -> new Results(players.size(), "꽝, 5000, 꽝, 3000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_SIZE_RESULTS_ERROR);
    }
}
