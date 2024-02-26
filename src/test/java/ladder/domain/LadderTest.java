package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @DisplayName("사다리 높이와 플레이어 수를 입력하면 Ladder 인스턴스를 생성한다.")
    @Test
    void Ladder_인스턴스_생성() {
        // Given
        final LadderHeight ladderHeight = new LadderHeight(5);
        final int playersCount = 4;

        // When
        Ladder ladder = Ladder.of(ladderHeight, playersCount);

        // Then
        assertThat(ladder).isNotNull();
    }
}
