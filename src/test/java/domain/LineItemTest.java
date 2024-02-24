package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineItemTest {

    @DisplayName("불리언 값에 해당하는 LineItem을 반환한다.")
    @ParameterizedTest
    @CsvSource({"true, CONNECTED", "false, UNCONNECTED"})
    void returnLineItemByBoolean(boolean actual, LineItem expected) {
        assertThat(LineItem.valueOf(actual)).isEqualTo(expected);
    }

    @DisplayName("주어진 LineItem이 UNCONNECTED인지 확인한다.")
    @ParameterizedTest
    @CsvSource({"UNCONNECTED, true", "CONNECTED, false"})
    void checkIsUnconnected(LineItem actual, boolean expected) {
        assertThat(LineItem.isUnconnected(actual)).isEqualTo(expected);
    }
}
