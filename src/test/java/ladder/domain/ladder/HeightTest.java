package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    private int heightValue;
    private Height height;

    @BeforeEach
    void setup() {
        heightValue = 3;
        height = new Height(heightValue);
    }

    @Test
    @DisplayName("Height 객체 getter 테스트")
    void getterTest() {
        assertThat(height.getHeight()).isEqualTo(heightValue);
    }

    @Test
    @DisplayName("Height 객체 equals 테스트")
    void equalsTest() {
        Height other = new Height(heightValue);
        assertThat(height).isEqualTo(other);
    }

}
