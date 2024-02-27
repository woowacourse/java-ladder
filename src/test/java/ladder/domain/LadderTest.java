package ladder.domain;

import ladder.util.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이와 플레이어 수를 입력하면 Ladder 인스턴스를 생성한다.")
    @Test
    void Ladder_인스턴스_생성() {
        // Given
        final Supplier<Boolean> randomGenerator = new RandomBooleanGenerator();
        final LadderHeight ladderHeight = new LadderHeight(5);
        final int playersCount = 4;

        // When
        Ladder ladder = Ladder.of(randomGenerator, ladderHeight, playersCount);

        // Then
        assertThat(ladder).isNotNull();
    }
}
