package laddergame.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    private Results results;
    ResultBuilder resultBuilder;

    @BeforeEach
    void setUp() {
        resultBuilder = new ResultBuilder("꽝,3000,5000,꽝");
        results = resultBuilder.makeResults();
    }

    @Test
    public void 객체_생성() {
        assertThat(results).isEqualTo(resultBuilder.makeResults());
    }

    @Test
    public void 해당_인덱스의_결과값_제대로_가져오는지() {
        assertThat(results.getResult(0).toString()).isEqualTo("꽝");
    }
}