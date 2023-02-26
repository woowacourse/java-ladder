package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderGameTest {

    @Test
    @DisplayName("사다리가 생성되지 않은 게임의 결과를 요청하면 예외를 던진다.")
    void should_ThrowException_When_ComputeResultWithoutLadder() {
        LadderGame ladderGame = new LadderGame(List.of("name1", "name2"));
        
        assertThatThrownBy(ladderGame::computeResult)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("아직 사다리가 생성되지 않은 게임입니다.");
    }

    @Test
    @DisplayName("사다리가 생성되지 않은 게임의 사다리 결과를 조회하면 예외를 던진다.")
    void should_ThrowException_When_GetLadderWithoutLadder() {
        LadderGame ladderGame = new LadderGame(List.of("name1", "name2"));

        assertThatThrownBy(ladderGame::ladder)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("아직 사다리가 생성되지 않은 게임입니다.");
    }
}
