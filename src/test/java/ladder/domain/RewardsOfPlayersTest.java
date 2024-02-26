package ladder.domain;

import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardsOfPlayersTest {
    @DisplayName("이름을 입력하면 보상을 반환한다.")
    @Test
    void getByNameTest() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Results results = new Results(List.of("100", "200"), players.count());
        Ladder ladder = new Ladder(players, height, () -> RIGHT);
        RewardsOfPlayers rewardsOfPlayers = new RewardsOfPlayers(ladder.getAllResultLocation(), results);

        assertThat(rewardsOfPlayers.getRewardByName("poby")).isEqualTo("200");
    }

    @DisplayName("존재하지 않는 이름을 입력하면 예외를 던진다.")
    @Test
    void invalidGetByNameTest() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Results results = new Results(List.of("100", "200"), players.count());
        Ladder ladder = new Ladder(players, height, () -> RIGHT);
        RewardsOfPlayers rewardsOfPlayers = new RewardsOfPlayers(ladder.getAllResultLocation(), results);

        assertThatThrownBy(() -> rewardsOfPlayers.getRewardByName("zeus"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }

    @DisplayName("전체 보상을 반환한다.")
    @Test
    void getAllResults() {
        Players players = new Players(List.of("poby", "honux"));
        Height height = new Height(3);
        Results results = new Results(List.of("100", "200"), players.count());
        Ladder ladder = new Ladder(players, height, () -> RIGHT);
        RewardsOfPlayers rewardsOfPlayers = new RewardsOfPlayers(ladder.getAllResultLocation(), results);

        assertAll(
                () -> assertThat(rewardsOfPlayers.getAllRewards().get("poby")).isEqualTo("200"),
                () -> assertThat(rewardsOfPlayers.getAllRewards().get("honux")).isEqualTo("100")
        );
    }
}
