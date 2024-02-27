package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultsTest {

    @DisplayName("주어진 목록으로 실행 결과를 저장한다.")
    @Test
    void findPlayerResult() {
        //given
        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");

        //when & then
        Assertions.assertThatCode(() -> new Results(rawResults)).doesNotThrowAnyException();
    }

}
