package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이가 정상적으로 생성된다.")
    void ladderHeightTest() {
        int ladderHeight = 1;
        assertDoesNotThrow(() -> new LadderHeight(ladderHeight));
    }

    @ParameterizedTest(name = "사다리 높이가 최대 높이에 도달하였는지 확인한다.")
    @CsvSource(delimiter = ':', value = {"1:false", "2:false", "3:false", "4:true"})
    void isMaxLadderHeightTest(int ladderSize, boolean expectedResult) {
        int height = 4;
        LadderHeight ladderHeight = new LadderHeight(height);
        assertThat(ladderHeight.isMaxHeight(ladderSize)).isEqualTo(expectedResult);
    }
}
