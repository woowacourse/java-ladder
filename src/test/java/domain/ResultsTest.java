package domain;

import domain.Collection.Result;
import domain.Collection.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    
    @Test
    @DisplayName("결과의 리스트로 Results 객체를 생성한다.")
    void createValidResultsTest() {
        Results results = Results.of(List.of("꽝", "5000", "꽝", "3000"));
        assertThat(results.getResults().stream().map(Result::getValue).collect(Collectors.toList())).containsExactly("꽝", "5000", "꽝", "3000");
    }
    
    @Test
    @DisplayName("인덱스를 통해 Results에서 결과값을 찾을 수 있다.")
    void getResultAtIndexTest() {
        int idx = 3;
        Results results = Results.of(List.of("꽝", "5000", "꽝", "3000"));
        assertThat(results.get(idx).getValue()).isEqualTo("3000");
    }
}