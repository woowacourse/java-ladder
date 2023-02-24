package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @Test
    @DisplayName("사다리 결과 배열을 입력받았을 때 배열의 크기만큼 result 객체를 생성")
    void makeResultsAsAmountOfResultArraySize() {

        String[] results = {"1등", "2등", "3등", "꽝"};
        int numberOfPlayers = 4;

        assertThat(Results.of(results, numberOfPlayers).getResults().size()).isEqualTo(results.length);
    }

    @Test
    @DisplayName("사다리 결과 개수가 플레이어 수와 불일치할 경우 예외 발생")
    void throwExceptionWhenNumberOfResultsIsNotMatchedWithPlayers() {

        String[] results = {"1등", "2등", "3등", "꽝"};
        int numberOfPlayers = 6;

        assertThatThrownBy(() -> Results.of(results, numberOfPlayers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 결과 수가 플레이어 수와 일치하지 않습니다.");
    }
}
