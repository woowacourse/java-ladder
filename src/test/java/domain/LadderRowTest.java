package domain;

import static domain.Line.EXIST;
import static domain.Line.NOT_EXIST;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @Test
    @DisplayName("연속된 Exist 값이 존재하면 예외를 던진다.")
    void should_throwException_when_consecutiveTrueExist() {
        List<Line> lines = List.of(EXIST, EXIST, NOT_EXIST);

        Assertions.assertThatThrownBy(() -> new LadderRow(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연속된 EXIST 값이 없다면 예외를 던지지 않는다.")
    void should_notThrowException_when_consecutiveTrueNotExist() {
        List<Line> lines = List.of(EXIST, NOT_EXIST, NOT_EXIST);

        Assertions.assertThatCode(() -> new LadderRow(lines))
                .doesNotThrowAnyException();
    }
}
