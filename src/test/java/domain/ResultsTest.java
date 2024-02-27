package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @Test
    @DisplayName("Results를 생성한다.")
    void createResults() {
        //given
        //when
        //then
        assertThatCode(() -> new Results(List.of(
                new Result("꽝"), new Result("5000"),
                new Result("꽝"), new Result("3000"))
        )).doesNotThrowAnyException();
    }

}
