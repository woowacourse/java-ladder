package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderRowTest {

    @Test
    @DisplayName("lines의 값 중 연속된 true가 존재하면 예외를 던진다.")
    void should_throwException_when_consecutiveTrueExist() {
        List<Boolean> lines = List.of(true, true, false);

        Assertions.assertThatThrownBy(() -> new LadderRow(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lines의 값 중 연속된 true가 없다면 예외를 던지지 않는다.")
    void should_notThrowException_when_consecutiveTrueNotExist() {
        List<Boolean> lines = List.of(true, false, false);

        Assertions.assertThatCode(() -> new LadderRow(lines))
                .doesNotThrowAnyException();
    }
}
