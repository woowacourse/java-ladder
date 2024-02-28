package domain;

import static domain.Height.MAX_OF_HEIGHT;
import static domain.Height.MIN_OF_HEIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이가 " + Height.MIN_OF_HEIGHT + "개 미만이면 예외가 발생한다.")
    void lessThanOneExceptionTest() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 "
                        + MAX_OF_HEIGHT + "개 이하여야 합니다.");
    }

    @Test
    @DisplayName("높이가 " + Height.MAX_OF_HEIGHT + "개 초과면 예외가 발생한다.")
    void moreThanHundredExceptionTest() {
        assertThatThrownBy(() -> new Height(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 " + MIN_OF_HEIGHT + "개 이상 "
                        + MAX_OF_HEIGHT + "개 이하여야 합니다.");
    }

    @Test
    @DisplayName("주어진 값이 높이의 끝인지 확인한다.")
    void isEndTest() {
        Height height = new Height(5);
        Assertions.assertThat(height.isEnd(5)).isTrue();
    }

}
