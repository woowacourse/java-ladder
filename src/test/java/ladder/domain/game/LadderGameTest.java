package ladder.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
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
                new Width(5)
        );
    }

    static Ladder ladder() {
        return LadderBuilder.builder()
                .height(new Height(5))
                .width(new Width(5))
                .ladderDirectionSelector(() -> LadderDirection.RIGHT)
                .build();
    }

    @DisplayName("사다리 게임 실행 결과에서 사용자에 맞는 결과를 반환한다.")
    @Test
    void play() {
        LadderGame ladderGame = LadderGame.of(players(), rewards(), ladder());
        LadderGameResult results = ladderGame.play();

        assertAll(
                () -> assertThat(results.rewardOf(new Player("zeus"))).isEqualTo(new Reward("아이폰14")),
                () -> assertThat(results.rewardOf(new Player("myung"))).isEqualTo(new Reward("아이폰15")),
                () -> assertThat(results.rewardOf(new Player("hotea"))).isEqualTo(new Reward("아이폰12")),
                () -> assertThat(results.rewardOf(new Player("baekk"))).isEqualTo(new Reward("아이폰13")),
                () -> assertThat(results.rewardOf(new Player("kyumm"))).isEqualTo(new Reward("아이폰11"))
        );
    }
}
