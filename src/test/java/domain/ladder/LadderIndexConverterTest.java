package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderIndexConverterTest {

    @Test
    @DisplayName("변환기는 최초에 인덱스 그대로를 반환한다.")
    void validCreationTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        // when
        List<Integer> actual = ladderIndexConverter.getResultIndex();
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    @DisplayName("매핑하려는 사다리 패턴의 크기와 기존 사다리의 크기가 일치하지 않으면, 예외를 발생한다.")
    void invalidPatternSizeTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        List<Boolean> rowPattern = List.of(true, false, true, false, true);
        // when, then
        assertThatThrownBy(() -> ladderIndexConverter.swapByRowPattern(rowPattern))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("주어진 사다리 패턴의 크기가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("사다리의 한 줄 패턴이 주어지면, 매핑 인덱스를 적절하게 변경한다.")
    void swapByRowTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        List<Boolean> rowPattern = List.of(true, false, true, false);
        List<Integer> expected = List.of(1, 0, 3, 2, 4);
        // when
        ladderIndexConverter.swapByRowPattern(rowPattern);
        List<Integer> actual = ladderIndexConverter.getResultIndex();
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
