package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultsTest {

    // TODO : 실행 결과 개수와 플레이어 수를 비교하는 것이 Result 객체의 책임인지 생각해보기
    @DisplayName("실행 결과의 개수가 플레이어 수보다 적으면 예외 처리 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    void validateResultSize(int playerSize) {
        List<String> results = new ArrayList<>();
        int sizeDifference = 5;
        for (int playerIndex = 0; playerIndex < playerSize - sizeDifference; playerIndex++) {
            results.add(String.valueOf(playerIndex));
        }
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResults(playerSize, results));
    }
}
