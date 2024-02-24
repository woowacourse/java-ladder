package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    @DisplayName("적절한 참여자 이름과, 높이로 생성하면 예외가 발생하지 않음")
    void testCreateLadderGame() {
        Assertions.assertThatCode(() -> new LadderGame("a,b,c", 5))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("적절한 참여자 이름과, 높이로 게임이 생성되면 사다리를 반환 할 수 있음")
    void testGetLadder() {
        LadderGame ladderGame = new LadderGame("a,b,c", 5);
        Assertions.assertThat(ladderGame.getLadder()).isNotNull();

    }

    @Test
    @DisplayName("적절한 참여자 이름과, 높이로 게임이 생성되면 이름을 반환할 수 있음")
    void testGetNames() {
        LadderGame ladderGame = new LadderGame("a,b,c", 5);
        Assertions.assertThat(ladderGame.getNames()).isNotNull();

    }

}