package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.ladder.Bridge;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.PlayerNames;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @DisplayName("참가자의 수와 실행 결과의 수가 같으면 객체가 잘 생성된다.")
    @Test
    void samePlayerCountAndMatchingItemsCount() {
        //given
        final PlayerNames playerNames = PlayerNames.from(List.of("pobi", "honux"));
        final Results results = new Results(List.of(new Result("꽝"), new Result("3000")));
        final Ladder ladder = new Ladder(List.of(
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)))
        );

        //when & then
        assertThatCode(() -> new LadderGame(playerNames, results, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 수와 실행 결과의 수가 다르면 예외가 발생한다.")
    @Test
    void doesNotSamePlayerCountAndMatchingItemsCount() {
        //given
        final PlayerNames playerNames = PlayerNames.from(List.of("pobi", "honux"));
        final Results results = new Results(List.of(new Result("꽝")));
        final Ladder ladder = new Ladder(List.of(
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)))
        );

        //when & then
        assertThatThrownBy(() -> new LadderGame(playerNames, results, ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 타기 전체 결과를 계산한다.")
    @Test
    void matchAllResult() {
        //given
        final PlayerNames playerNames = PlayerNames.from(List.of("pobi", "honux", "crong", "jk"));
        final Results results = new Results(List.of(
                new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"))
        );
        final Ladder ladder = new Ladder(List.of(
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)),
                new Floor(List.of(Bridge.NOT_EXIST, Bridge.EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.NOT_EXIST, Bridge.EXIST, Bridge.NOT_EXIST)),
                new Floor(List.of(Bridge.EXIST, Bridge.NOT_EXIST, Bridge.EXIST)))
        );
        final LadderGame ladderGame = new LadderGame(playerNames, results, ladder);

        //when
        final GameResults gameResults = ladderGame.calculateGameResults();

        //when
        assertAll(
                () -> assertThat(gameResults.findBy(0)).isEqualTo(new GameResult("pobi", "꽝")),
                () -> assertThat(gameResults.findBy(1)).isEqualTo(new GameResult("honux", "3000")),
                () -> assertThat(gameResults.findBy(2)).isEqualTo(new GameResult("crong", "꽝")),
                () -> assertThat(gameResults.findBy(3)).isEqualTo(new GameResult("jk", "5000"))
        );
    }
}
