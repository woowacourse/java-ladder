package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.game.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderBuilder;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

class LadderGameTest {

    static Players players() {
        return new Players(List.of(
                new Player("zeus"),
                new Player("myung"),
                new Player("hotea"),
                new Player("baekk"),
                new Player("kyumm")
        ));
    }

    static Rewards rewards() {
        return new Rewards(
                List.of(
                        new Reward("아이폰15"),
                        new Reward("아이폰14"),
                        new Reward("아이폰13"),
                        new Reward("아이폰12"),
                        new Reward("아이폰11")
                ),
                new Width<>(5)
        );
    }

    static Ladder ladder() {
        return LadderBuilder.builder()
                .height(new Height<>(5))
                .width(new Width<>(5))
                .ladderDirectionSelector(() -> LadderDirection.RIGHT)
                .build();
    }

    @DisplayName("사다리 게임을 실행한다.")
    @Test
    void play() {
        LadderGame ladderGame = LadderGame.of(players(), rewards(), ladder());
        Map<Player, Reward> results = ladderGame.play();

        assertAll(
                () -> assertThat(results.keySet()).containsAll(players().players()),
                () -> assertThat(results.values()).containsAll(rewards().getRewards()),
                () -> assertThat(results.get(new Player("zeus"))).isEqualTo(new Reward("아이폰14")),
                () -> assertThat(results.get(new Player("myung"))).isEqualTo(new Reward("아이폰15")),
                () -> assertThat(results.get(new Player("hotea"))).isEqualTo(new Reward("아이폰12")),
                () -> assertThat(results.get(new Player("baekk"))).isEqualTo(new Reward("아이폰13")),
                () -> assertThat(results.get(new Player("kyumm"))).isEqualTo(new Reward("아이폰11"))
        );
    }
}
