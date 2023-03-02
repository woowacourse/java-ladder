//package ladder.domain;
//
//import ladder.domain.player.PlayerName;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class PlayerTest {
//    private Player player;
//    private PlayerName name;
//    private Reward reward;
//
//    @BeforeEach
//    void setup() {
//        name = new PlayerName("포비");
//        player = new Player(name);
//        reward = new Reward("통과");
//    }
//
//    @Test
//    @DisplayName("Player 객체 getName 테스트")
//    void getNameTest() {
//        assertThat(player.getName())
//                .isEqualTo(name.getName());
//    }
//
//    @Test
//    @DisplayName("Player 객체 determineReward 테스트")
//    void determineRewardTest() {
//        player.determineReward(reward);
//
//        assertThat(player.getReward())
//                .isEqualTo(reward.getName());
//    }
//}
