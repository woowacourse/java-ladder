package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.LadderItem;

class LadderItemTest {

    @DisplayName("사다리 연결 여부에 따른 사다리 형태 확인")
    @ParameterizedTest
    @CsvSource(value = {"true,-----|", "false,'     |'"}, delimiter = ',')
    void getShapeByIsConnected(boolean isConnected, String expected) {
        assertThat(LadderItem.getShapeByIsConnected(isConnected)).isEqualTo(expected);
    }
}