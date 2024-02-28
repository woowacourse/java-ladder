package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 생성기")
class LadderGeneratorTest {

    @Test
    @DisplayName("가로 세로 길이에 맞게 생성된다.")
    void generate() {
        // given
        int width = 6;
        int height = 5;

        // when
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        Ladder ladder = ladderGenerator.generate();

        // then
        assertThat(ladder.width()).isEqualTo(width);
        assertThat(ladder.height()).isEqualTo(height);
    }
}
