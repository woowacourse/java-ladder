package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("결과")
class ResultsTest {
    @Test
    @DisplayName("결과 생성에 성공한다.")
    public void createResults() {
        //given
        List<String> resultNames = List.of("꽝", "5000", "꽝", "3000");

        //when
        Results results = Results.from(resultNames);

        //then
        assertEquals(results.getResults().get(0).name(), resultNames.get(0));
    }
}
