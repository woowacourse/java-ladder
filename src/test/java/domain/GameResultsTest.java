package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultsTest {

    // TODO : 실행 결과 개수와 플레이어 수를 비교하는 것이 Result 객체의 책임인지 생각해보기
    @DisplayName("실행 결과의 개수가 플레이어 수보다 적으면 예외 처리 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "10:11", "11:10", "19:20", "20:21"}, delimiter = ':')
    void validateResultSize(String playerSize, String resultsSize) {
        List<String> results = new ArrayList<>();
        for (int resultIndex = 0; resultIndex < Integer.parseInt(resultsSize); resultIndex++) {
            results.add(String.valueOf(resultIndex));
        }
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResults(Integer.parseInt(playerSize), results));
    }

    @DisplayName("실행 결과가 비어있는 경우 예외 처리 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullAndEmpty(List<String> results) {
        int playerSize = 3;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResults(playerSize, results));
    }

//    @DisplayName("실행 결과를 일급컬렉션에 저장한다.")
//    @Test
//    void validateResultSize(String playerSize, String resultsSize) {
//        List<String> results = new ArrayList<>();
//        for (int resultIndex = 0; resultIndex < Integer.parseInt(resultsSize); resultIndex++) {
//            results.add(String.valueOf(resultIndex));
//        }
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> new GameResults(Integer.parseInt(playerSize), results));
//    }

}
