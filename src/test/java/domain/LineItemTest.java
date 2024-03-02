package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import view.LineItem;

class LineItemTest {

    @DisplayName("불리언 값에 해당하는 LineItem을 반환한다.")
    @ParameterizedTest
    @CsvSource({"true, CONNECTED", "false, UNCONNECTED"})
    void returnLineItemByBoolean(boolean actual, LineItem expected) {
        assertThat(LineItem.valueOf(actual)).isEqualTo(expected);
    }
}
