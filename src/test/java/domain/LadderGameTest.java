package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LadderGameTest {

    @DisplayName("사다리 게임 진행 결과로 플레이어의 최종위치를 알 수 있다.")
    @Test
    void playTest() {
        // given
        final Users users = new Users(List.of(new User("pobi"), new User("crong"), new User("jk"), new User("honux")));
        final LadderGame ladderGame = new LadderGame(
                new Height(4),
                users,
                ((width, height) -> new Ladder(List.of(
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                        new Line(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
                ))));
        final WinningResults winningResults = new WinningResults(List.of(new WinningResult("1"), new WinningResult("2"), new WinningResult("3"), new WinningResult("4")));
        // when
        final Result result = ladderGame.play(winningResults);
        final Map<String, WinningResult> gameResult = result.getResult("all");

        // then
        Assertions.assertThat(gameResult.get("pobi").getWinningResult()).isEqualTo("4");
        Assertions.assertThat(gameResult.get("crong").getWinningResult()).isEqualTo("1");
        Assertions.assertThat(gameResult.get("jk").getWinningResult()).isEqualTo("3");
        Assertions.assertThat(gameResult.get("honux").getWinningResult()).isEqualTo("2");
    }
}
