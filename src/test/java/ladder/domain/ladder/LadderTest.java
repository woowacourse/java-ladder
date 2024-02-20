package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 생성자 테스트")
    void testConstruct() {
        int playerCount = 4;
        int height = 5;
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        Ladder ladder = new Ladder(playerCount, height, booleanGenerator);

        assertThat(ladder).extracting("playerCount")
                .isEqualTo(4);
        assertThat(ladder).extracting("height")
                .isEqualTo(5);
        assertThat(ladder).extracting("booleanGenerator")
                .isInstanceOf(RandomBooleanGenerator.class);
    }
}
