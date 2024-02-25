package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("Player 인스턴스들을 입력하면 인스턴스를 생성한다.")
    @Test
    void Players_인스턴스_생성() {
        // Given
        final UserNames userNames = UserNames.of(List.of("kelly", "pobi", "con", "hi"));
        final LadderHeight ladderHeight = new LadderHeight(5);

        // When
        Players players = Players.of(userNames, ladderHeight);

        // Then
        assertThat(players).isNotNull();
    }
}
