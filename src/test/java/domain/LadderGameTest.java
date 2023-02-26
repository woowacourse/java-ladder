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
                new Width(users.getCount() - 1),
                ((width, height) -> List.of(
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                        new Line(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                        new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
                )));

        // when
        final Result result = ladderGame.play(users, List.of("1", "2", "3", "4"));
        final Map<String, String> gameResult = result.getResult("all");

        // then
        Assertions.assertThat(gameResult.get("pobi")).isEqualTo("4");
        Assertions.assertThat(gameResult.get("crong")).isEqualTo("1");
        Assertions.assertThat(gameResult.get("jk")).isEqualTo("3");
        Assertions.assertThat(gameResult.get("honux")).isEqualTo("2");
    }
}
