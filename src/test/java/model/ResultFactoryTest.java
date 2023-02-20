package model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

public class ResultFactoryTest {
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private static final String MAXIMUM_RESULT_LENGTH_ERROR = "[ERROR] 게임 결과 입력값 길이는 %d 이하로만 가능합니다.";
    private static final String WRONG_SIZE_RESULTS_ERROR = "[ERROR] 사다리 게임 결과 값의 개수는 전체 사람의 수와 동일해야 합니다.";

    @Test
    @DisplayName("Result 객체 리스트 생성 성공 테스트")
    void createResultsTest() {
        assertThatNoException().isThrownBy(() -> ResultFactory.create(4, "꽝, 5000, 꽝, 3000"));
    }

    @Test
    @DisplayName("결과값 길이 제한으로 인한 Result 객체 생성 실패 테스트")
    void limitResultLengthTest() {
        assertThatThrownBy(() -> ResultFactory.create(2,"abcdef, gehijk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(MAXIMUM_RESULT_LENGTH_ERROR, MAXIMUM_RESULT_LENGTH));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi, neo, hiiro", "pobi, neo, hiiro, ocean, kevin"})
    @DisplayName("사다리 게임 결과 값의 수와 전체 사람 수가 같은지 검증 기능 테스트")
    void validateRightResultsSizeTest(String inputNames) {
        //given
        Players players = new Players(NameFactory.create(inputNames));

        //then
        assertThatThrownBy(() -> ResultFactory.create(players.size(), "꽝, 5000, 꽝, 3000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_SIZE_RESULTS_ERROR);
    }

    @Test
    @DisplayName("사다리 게임 결과는 쉼표를 기준으로 입력받는 기능 테스트")
    void splitResultsByCommaTest() {
        //given
        List<Result> createdResults = ResultFactory.create(4, "꽝 , 5000 , 꽝 , 3000");

        //when
        List<String> thenResult = createdResults.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());

        //then
        assertThat(thenResult).isEqualTo(List.of("꽝", "5000", "꽝", "3000"));
    }
}
