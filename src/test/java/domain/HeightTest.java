package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @DisplayName("높이를 조회할 수 있다.")
    @Test
    void create() {
        int inputHeight = 3;
        Height height = new Height(inputHeight);

        int actualHeight = height.getHeight();

        assertThat(actualHeight).isEqualTo(inputHeight);
    }
}
