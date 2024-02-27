package ladder.domain;

import ladder.util.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @DisplayName("사다리와 플레이어들을 입력하면 사다리 게임 실행 후 결과를 반환한다.")
    @Test
    void 사다리_게임_실행_후_결과_반환() {
        // Given
        Ladder ladder = Ladder.of(new RandomBooleanGenerator(), new LadderHeight(5), 4);
        Players players = Players.of(PlayerNames.of(List.of("pobi", "honux", "crong", "jk")), new LadderHeight(5));

        // When
        LadderGameResult ladderGameResult = LadderGame.play(ladder, players);

        // Then
        assertThat(ladderGameResult).isNotNull();
    }
}
