package domain;

import constant.Exception;
import exception.domain.HeightExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HeightTest {

    @Test
    @DisplayName("높이가 " + Height.MIN_OF_HEIGHT + "개 미만이면 예외가 발생한다.")
    void lessThanOneExceptionTest() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HeightExceptionMessage.OUT_OF_RANGE_HEIGHT.getExceptionMessage());
    }

    @Test
    @DisplayName("높이가 " + Height.MAX_OF_HEIGHT + "개 초과면 예외가 발생한다.")
    void moreThanHundredExceptionTest() {
        assertThatThrownBy(() -> new Height(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HeightExceptionMessage.OUT_OF_RANGE_HEIGHT.getExceptionMessage());
    }

}
