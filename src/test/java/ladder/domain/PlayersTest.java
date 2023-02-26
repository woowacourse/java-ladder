package ladder.domain;

import ladder.domain.player.Players;
import ladder.domain.player.exception.DuplicatePlayerNameException;
import ladder.domain.player.exception.PlayerNumberException;
import ladder.domain.player.exception.NoSuchPlayerException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayersTest {

    @Test
    void Players_생성_테스트() {
        assertThatCode(() -> Players.from(List.of("박정훈", "김혜수", "남지윤")))
                .doesNotThrowAnyException();
    }

    @Test
    void 총_플레이어는_두명_이상이_아니면_예외_발생() {
        assertThatThrownBy(() -> Players.from(List.of("pobi")))
                .isInstanceOf(PlayerNumberException.class);
    }

    @Test
    void 겹치는_플레이어_이름이_있으면_예외_발생() {
        assertThatThrownBy(() -> Players.from(List.of("pobi", "crong", "pobi")))
                .isInstanceOf(DuplicatePlayerNameException.class);
    }

    @Test
    void 없는_플레이어_조회_시_예외_발생() {
        Players players = Players.from(List.of("pobi", "crong"));

        assertThatThrownBy(() -> players.findByName("po"))
                .isInstanceOf(NoSuchPlayerException.class);
    }
}