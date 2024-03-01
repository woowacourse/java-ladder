package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderTest {

    @DisplayName("사다리 생성")
    @Test
    void makeLadderTest() {
        Height height = new Height("5");
        TestBooleanGenerator testBooleanGenerator = new TestBooleanGenerator(true);

        assertThatCode(() -> Ladder.of(height, 5, testBooleanGenerator))
                .doesNotThrowAnyException();
    }
}