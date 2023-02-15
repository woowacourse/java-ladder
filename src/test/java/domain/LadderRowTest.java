package domain;

import static utils.constants.ErrorMessages.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.constants.ErrorMessages;

public class LadderRowTest {

    @Test
    @DisplayName("lines의 값 중 연속된 true가 존재하면 예외를 던진다.")
    void ladderRowFailTest() {
        List<Boolean> lines = List.of(true, true, false);

        Assertions.assertThatThrownBy(() -> new LadderRow(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lines의 값 중 연속된 true가 없다면 생성에 성공한다.")
    void ladderRowSuccessTest() {
        List<Boolean> lines = List.of(true, false, false);

        Assertions.assertThatCode(() -> new LadderRow(lines))
                .doesNotThrowAnyException();
    }
}
