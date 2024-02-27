package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ResultsTest {

    @DisplayName("주어진 목록으로 실행 결과를 저장한다.")
    @Test
    void findPlayerResult() {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        int playerCount = 4;

        //when & then
        Assertions.assertThatCode(() -> Results.of(rawResults, playerCount)).doesNotThrowAnyException();
    }

    @DisplayName("실행 결과가 참가자 수보다 적거나 많으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void invalidResultCount(int playerCount) {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");

        //when & then
        Assertions.assertThatThrownBy(() -> Results.of(rawResults, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.INVALID_RESULTS_COUNT);
    }

}
