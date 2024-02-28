package domain.ladder;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.Player;
import util.RandomBooleanGenerator;
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

    @DisplayName("플레이어를 입력받으면 사다리를 기반으로 한 층 이동시킨다.")
    @Test
    void 플레이어_사다리_이동() {
        // Given
        Ladder ladder = Ladder.of(() -> true, new LadderHeight(5), 4);
        Player player = Player.of("kelly", 1, 5);

        // When
        ladder.movePlayer(player);

        // Then
        assertThat(player.getCurrentLineNumber().value()).isEqualTo(2);
        assertThat(player.getCurrentLineFloor().value()).isEqualTo(4);
    }
}
