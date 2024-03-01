package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class ResultsTest {

    @DisplayName("주어진 목록으로 실행 결과를 저장한다.")
    @Test
    void findPlayerResult() {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        int playerCount = 4;

        //when & then
        assertThatCode(() -> Results.of(rawResults, playerCount)).doesNotThrowAnyException();
    }

    @DisplayName("실행 결과가 참가자 수보다 적거나 많으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void invalidResultCount(int playerCount) {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");

        //when & then
        assertThatThrownBy(() -> Results.of(rawResults, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.INVALID_RESULTS_COUNT);
    }

    @DisplayName("주어진 위치의 결과를 반환한다.")
    @Test
    void findResultAtIndex() {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        Results results = Results.of(rawResults, rawResults.size());
        int index = 1;
        String expectedResult = "2000";

        //when
        Result result = results.findAtIndex(index);

        //then
        assertThat(result.getValue()).isEqualTo(expectedResult);
    }
}
