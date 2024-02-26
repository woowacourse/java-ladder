package laddergame.domain.gameelements.results;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultsTest {
    @DisplayName("참여하는 사람 수와 게임 결과의 수가 일치되지 않으면 Result 객체가 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5})
    void playerNumerNotEqualsResultNumberTest(int peopleNumber) {
        List<String> results = List.of("꽝", "1000", "꽝");
        assertThrows(IllegalArgumentException.class,
                () -> new Results(results, peopleNumber));
    }

    @DisplayName("참여하는 사람 수와 게임 결과의 수가 일치되어야 Result 객체가 생성된다.")
    @Test
    void playerNumberEqualsResultNumberTest() {
        List<String> results = List.of("꽝", "1000", "꽝");
        assertDoesNotThrow(() -> new Results(results, results.size()));
    }

}
