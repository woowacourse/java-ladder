package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.ladder.LadderRow;
import dto.LadderRowDto;
import java.util.List;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderRowTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 10})
    @DisplayName("올바른 범위의 수가 주어지면, 세로줄을 생성한다.")
    void validPlayerCountCreationTest(int playerCount) {
        assertDoesNotThrow(() -> new LadderRow(playerCount));
    }

    @Test
    @DisplayName("초기에 생성했을 때, 가로줄은 없다.")
    void initialCreationEmptyCrossingLinesTest() {
        // given
        LadderRow ladderRow = new LadderRow(5);
        // when
        LadderRowDto status = ladderRow.getRowPattern();
        List<Boolean> actual = status.rowPattern();
        // then
        assertThat(actual).containsOnly(false);
    }

    @Test
    @DisplayName("항상 true를 반환하는 generator를 가지는 경우, 이전에 true가 나온 경우, false를 반환한다.")
    void generateFalseAfterTrueTest() {
        // given
        BooleanSupplier trueSupplier = () -> true;
        LadderRow ladderRow = new LadderRow(6);
        // when
        ladderRow.createPattern(trueSupplier);
        LadderRowDto status = ladderRow.getRowPattern();
        List<Boolean> actual = status.rowPattern();
        List<Boolean> expected = List.of(true, false, true, false, true);
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
