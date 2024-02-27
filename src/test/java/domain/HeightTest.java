package domain;

import domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @DisplayName("높이를 조회할 수 있다.")
    @Test
    void create() {
        int inputHeight = 3;
        Height height = new Height(inputHeight);

        int actualHeight = height.getHeight();

        assertThat(actualHeight).isEqualTo(inputHeight);
    }

    @DisplayName("높이는 1 이상만 허용한다.")
    @Test
    void checkHeight() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 최소 1 이어야 합니다.");
    }
}
