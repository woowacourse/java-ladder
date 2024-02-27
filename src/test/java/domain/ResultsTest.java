package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @Test
    @DisplayName("Result 수는 사용자 수와 일치해야 한다.")
    void equalToPersonCount() {
        //given
        int personCount = 3;
        List<Result> prizes = List.of(
                new Result("꽝"),
                new Result("5000"),
                new Result("꽝"),
                new Result("3000"));
        //when
        //then
        assertThatThrownBy(() -> Results.of(prizes, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
