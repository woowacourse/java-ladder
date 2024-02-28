package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNamesTest {

    @DisplayName("플레이어들 객체가 정상적으로 생성된다.")
    @Test
    void createPlayerNames() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        assertThatCode(() -> new PlayerNames(List.of(player1, player2)))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어가 1명 이하인 경우 예외를 발생한다.")
    @Test
    void createPlayerNamesWithInvalidSize() {
        PlayerName player = new PlayerName("dodo");
        assertThatThrownBy(() -> new PlayerNames(List.of(player)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 중복된 경우 예외를 발생한다.")
    @Test
    void createPlayerNamesWithOverlap() {
        assertThatThrownBy(
                () -> new PlayerNames(List.of(new PlayerName("dodo"), new PlayerName("dodo"), new PlayerName("capy"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 몇번째 순서인지 반환합니다.(0부터)")
    @Test
    void findPlayerNameOrderNumber() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        PlayerNames playerNames = new PlayerNames(List.of(player1, player2));

        assertThat(playerNames.getPlayerNameOrderNumber("dodo")).isEqualTo(0);
    }

    @DisplayName("플레이어가 존재한다면 true를 반환합니다..")
    @Test
    void isExistPlayer() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        PlayerNames playerNames = new PlayerNames(List.of(player1, player2));
        String checkName = "dodo";

        Assertions.assertTrue(playerNames.isExistPlayer(checkName));
    }

    @DisplayName("플레이어가 존재한다면 true를 반환합니다..")
    @Test
    void isExistPlayerWithNotExist() {
        PlayerName player1 = new PlayerName("dodo");
        PlayerName player2 = new PlayerName("capy");
        PlayerNames playerNames = new PlayerNames(List.of(player1, player2));
        String checkName = "pobi";

        Assertions.assertFalse(playerNames.isExistPlayer(checkName));
    }
}
