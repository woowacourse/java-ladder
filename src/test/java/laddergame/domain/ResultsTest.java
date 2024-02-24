package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("결과들")
class ResultsTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createResults() {
        //given
        List<String> resultNames = List.of("꽝", "5000", "꽝", "3000");

        //when
        Results results = Results.from(resultNames);

        //then
        assertEquals(results.getResults().get(0).name(), resultNames.get(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    @DisplayName("이름에 빈칸을 허용하지 않는다.")
    public void resultsBlankException(final String name) {
        //given
        List<String> resultNames = List.of(name);

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Results.from(resultNames));
    }

    @Test
    @DisplayName("플레이어 수와 맞지 않을 경우, 예외가 발생한다.")
    public void notMatchPlayersResult() {
        //given
        List<String> resultNames = List.of("choco", "lemon");
        final int playerCount = 3;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Results.from(resultNames, playerCount));
    }
}
