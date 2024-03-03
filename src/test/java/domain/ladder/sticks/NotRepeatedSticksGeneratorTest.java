package domain.ladder.sticks;

import domain.ladder.stick.Stick;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NotRepeatedSticksGeneratorTest {

    @DisplayName("채워진 막대가 연속되지 않도록 막대들을 생성한다.")
    @Test
    void generateSticksNotRepeatedFilledStick() {
        int stickCount = 3;

        NotRepeatedSticksGenerator generator = new NotRepeatedSticksGenerator(() -> Stick.FILLED);
        List<Stick> generatedSticks = generator.generate(stickCount);

        assertThat(generatedSticks).containsExactlyElementsOf(List.of(Stick.FILLED, Stick.NOT_FILLED, Stick.FILLED));
    }
}
