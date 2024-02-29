package domain;

import static domain.ladder.Height.MAX_OF_HEIGHT;
import static domain.ladder.Height.MIN_OF_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.ladder.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {


    @Test
    @DisplayName("높이가 증가한다")
    void moveUpTest() {
        Height height = new Height(0);
        height.moveUp();
        assertThat(height.equals(new Height(1))).isTrue();
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
        assertThat(height.isEqualTo(5)).isTrue();
    }

}
