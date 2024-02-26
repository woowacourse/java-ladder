package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.RowPatternDto;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderIndexConverterTest {

    @Test
    @DisplayName("변환기는 최초에 인덱스 그대로를 반환한다.")
    void validCreationTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        // when, then
        for (int i = 0; i < 5; i++) {
            int index = ladderIndexConverter.getMappedIndexByPlayerIndex(i);
            assertThat(index).isEqualTo(i);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    @DisplayName("매핑하고자 하는 인덱스가 범위를 넘어가는 경우, 예외를 발생한다.")
    void mappingIndexOutOfRangeTest(int index) {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        // when, then
        assertThatThrownBy(() -> ladderIndexConverter.getMappedIndexByPlayerIndex(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("주어진 인덱스가 매핑 범위를 벗어납니다.");
    }

    @Test
    @DisplayName("매핑하려는 사다리 패턴의 크기와 기존 사다리의 크기가 일치하지 않으면, 예외를 발생한다.")
    void invalidPatternSizeTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        RowPatternDto rowPatternDto = new RowPatternDto(List.of(true, false, true, false, true));
        // when, then
        assertThatThrownBy(() -> ladderIndexConverter.swapByRowPattern(rowPatternDto))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("주어진 사다리 패턴의 크기가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("사다리의 한 줄 패턴이 주어지면, 매핑 인덱스를 적절하게 변경한다.")
    void swapByRowTest() {
        // given
        LadderIndexConverter ladderIndexConverter = new LadderIndexConverter(5);
        RowPatternDto rowPatternDto = new RowPatternDto(List.of(true, false, true, false));
        // when
        ladderIndexConverter.swapByRowPattern(rowPatternDto);
        List<Integer> actual = IntStream.range(0, 5)
                .map(ladderIndexConverter::getMappedIndexByPlayerIndex)
                .boxed()
                .toList();
        // then
        List<Integer> expected = List.of(1, 0, 3, 2, 4);
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
