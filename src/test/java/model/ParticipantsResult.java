package model;

import model.position.Position;
import model.result.Result;
import model.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ParticipantsResult {

    @DisplayName("위치에 따라 결과를 알 수 있다.")
    @Test
    void getResult() {
        Results results = new Results(List.of("꽝", "5000", "꽝", "3000"), 4);
        assertAll(
                () -> assertThat(results.getResult(Position.valueOf(0))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(Position.valueOf(1))).isEqualTo(new Result("5000")),
                () -> assertThat(results.getResult(Position.valueOf(2))).isEqualTo(new Result("꽝")),
                () -> assertThat(results.getResult(Position.valueOf(3))).isEqualTo(new Result("3000"))
        );
    }
}
