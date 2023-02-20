package ladder.domain.ladder;

import ladder.domain.valueGenerator.IntegerGenerator;
import ladder.domain.valueGenerator.MockBooleanGenerator;
import ladder.domain.valueGenerator.MockIntegerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {
    private int heightValue;
    private Height height;
    private IntegerGenerator integerGenerator;

    @BeforeEach
    void setup() {
        heightValue = 3;
        integerGenerator = new MockIntegerGenerator(List.of(heightValue));
        height = Height.create(heightValue, integerGenerator);
    }

    @Test
    @DisplayName("Height 객체 getter 테스트")
    void getterTest() {
        assertThat(height.getHeight()).isEqualTo(heightValue);
    }

    @Test
    @DisplayName("Height 객체 equals 테스트")
    void equalsTest() {
        Height other = Height.create(heightValue, integerGenerator);
        assertThat(height).isEqualTo(other);
    }
}
