package ladder.domain.resource.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.resource.line.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    LadderGenerator ladderGenerator = new LadderGenerator(new RandomLineGenerator());

    @DisplayName("원하는 가로와 세로 길이를 가진 사다리를 생성한다.")
    @Test
    void generateTest() {
        //given
        int height = 2;
        int width = 2;

        //when
        Ladder ladder = ladderGenerator.generate(height, width);

        //then
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getWidth()).isEqualTo(width);
    }
}
