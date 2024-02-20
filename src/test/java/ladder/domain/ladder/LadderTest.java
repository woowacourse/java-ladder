package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.generator.RandomRungGenerator;
import ladder.domain.generator.RungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("참여자 수, 높이와 발판 생성기를 가진다.")
    void testConstruct() {
        int playerCount = 4;
        int height = 5;
        RungGenerator rungGenerator = new RandomRungGenerator();
        Ladder ladder = new Ladder(playerCount, height, rungGenerator);

        assertThat(ladder).extracting("playerCount")
                .isEqualTo(4);
        assertThat(ladder).extracting("height")
                .isEqualTo(5);
        assertThat(ladder).extracting("rungGenerator")
                .isInstanceOf(RandomRungGenerator.class);
    }
}
