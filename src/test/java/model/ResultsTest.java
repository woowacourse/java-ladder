package model;

import model.position.CachedPosition;
import model.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultsTest {

    @DisplayName("위치에 따라 결과를 알 수 있다.")
    @Test
    void getResult() {
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"));
        assertAll(
                () -> assertThat(results.getResult(CachedPosition.valueOf(0))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(CachedPosition.valueOf(1))).isEqualTo(new Result("5000")),
                () -> assertThat(results.getResult(CachedPosition.valueOf(2))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(CachedPosition.valueOf(3))).isEqualTo(new Result("3000"))
        );
    }
}
