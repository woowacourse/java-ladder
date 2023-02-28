package domain;

import static domain.Line.EXIST;
import static domain.Line.NOT_EXIST;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "사다리의 N번째 세로 줄 기준으로, 주변에 존재하는 Line의 인덱스를 반환한다.")
    @CsvSource({"0,0", "1,0", "2,-100", "3,3", "4,3"})
    void getExistingLineIndexTest(int index, int existingLineIndex) {
        List<Line> lines = List.of(EXIST, NOT_EXIST, NOT_EXIST, EXIST);
        LadderRow ladderRow = new LadderRow(lines);

        Assertions.assertThat(ladderRow.getExistingLineIndex(index)).isEqualTo(existingLineIndex);
    }
}
