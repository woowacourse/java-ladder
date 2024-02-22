package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderItemTest {

    @DisplayName("사다리 연결 여부로 사다리 형태 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"true,-----|", "false,'     |'"}, delimiter = ',')
    void getShapeByIsConnected(Boolean isConnected, String expected) {
        assertThat(LadderItem.getShapeByIsConnected(isConnected)).isEqualTo(expected);
    }
}