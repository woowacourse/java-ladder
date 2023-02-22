package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    @Test
    @DisplayName("결과의 리스트로 Results 객체를 생성한다.")
    void createValidResultsTest(){
        List<Result> collectedList = Stream.of("꽝", "5000", "꽝", "3000")
                .map(Result::from)
                .collect(Collectors.toList());
        Results results = Results.of(collectedList);
        assertThat(results.getResults()).containsExactly("꽝",)
    }
}
