package ladder.domain.ladder;

import ladder.domain.valueGenerator.MockValueDataGenerator;
import ladder.domain.valueGenerator.ValueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {
    private int heightValue;
    private Height height;
    private ValueGenerator valueGenerator;

    @BeforeEach
    void setup() {
        heightValue = 3;
        valueGenerator = new MockValueDataGenerator();
        height = Height.create(heightValue, valueGenerator);
    }

    @Test
    @DisplayName("Height 객체 getter 테스트")
    void getterTest() {
        assertThat(height.getHeight()).isEqualTo(heightValue);
    }

    @Test
    @DisplayName("Height 객체 equals 테스트")
    void equalsTest() {
        Height other = Height.create(heightValue, valueGenerator);
        assertThat(height).isEqualTo(other);
    }
}
