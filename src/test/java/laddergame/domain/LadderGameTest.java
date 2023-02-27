package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {
    @DisplayName("player 여러명일때 사다리 잘 타서 포지션 이동 잘되는지 확인 (player 3, height 2)")
    @Test
    void player3_height2() {
        Players players = new Players(List.of("jena", "beav", "pobi"));
        Ladder ladder = new Ladder(players, new Height(2),
                new TestTrueOrFalseGenerator(new ArrayList<>(List.of(true, false, false, true))));

        List<Line> lines = ladder.getLines();
        List<Integer> resultPosition = new ArrayList<>();

        for (Line line : lines) {
            for (Player player : players.getPlayers()) {
                player.move(line.isStep(player.getPosition() - 1), line.isStep(player.getPosition()));
            }
        }
        for (Player player : players.getPlayers()) {
            resultPosition.add(player.getPosition());
        }

        assertThat(resultPosition).isEqualTo(List.of(2, 0, 1));
    }

    @DisplayName("player 3, height 5")
    @Test
    void player3_height5() {
        Players players = new Players(List.of("jena", "beav", "pobi"));
        Ladder ladder = new Ladder(players, new Height(5),
                new TestTrueOrFalseGenerator(new ArrayList<>(List.of(true, false, false, true, false, true, true, false, false, false))));

        List<Line> lines = ladder.getLines();
        List<Integer> resultPosition = new ArrayList<>();

        for (Line line : lines) {
            for (Player player : players.getPlayers()) {
                player.move(line.isStep(player.getPosition() - 1), line.isStep(player.getPosition()));
            }
        }
        for (Player player : players.getPlayers()) {
            resultPosition.add(player.getPosition());
        }

        assertThat(resultPosition).isEqualTo(List.of(0, 1, 2));
    }

    @DisplayName("사다리 게임 완료 후 플레이어들이 보상 잘 찾아갔는지 확인")
    @Test
    void player_get_right_reward() {
        Players players = new Players(List.of("jena", "beav", "pobi"));
        Ladder ladder = new Ladder(players, new Height(5),
                new TestTrueOrFalseGenerator(new ArrayList<>(List.of(true, false, false, true, false, true, true, false, false, false))));
        Rewards rewards = new Rewards(List.of("꽝", "3000", "60"));

        LadderGame ladderGame = new LadderGame(players, rewards, ladder);
        ladderGame.start();

        assertThat(ladderGame.getReward("jena").getRewardName()).isEqualTo("꽝");
    }

}
