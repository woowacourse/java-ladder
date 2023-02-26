package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    public static final String PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = "참여자 수는 2 ~ 20명만 가능합니다.";

    @Test
    @DisplayName("모든 게임 참여자들의 이름 생성")
    void createPlayerNamesSuccess() {
        List<String> playerNamesInput = List.of("pobi", "honux", "crong", "jk");

        assertThat(Players.from(playerNamesInput).getPlayers())
                .map(Player::getName)
                .containsExactly("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("모든 게임 참여자들의 이름은 중복될 수 없다")
    void createPlayerNamesFail() {
        List<String> playerNamesInput = List.of("pobi", "pooh", "pooh", "jk");

        assertThatThrownBy(() -> Players.from(playerNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복될 수 없습니다.");
    }

    @DisplayName("한명만 참여 할 수 없다")
    @Test
    void createPlayerNumberUnderNumberFail() {
        List<String> input = List.of("pobi");

        assertThatThrownBy(() -> Players.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    @DisplayName("20명 이상은 참여 할 수 없다")
    @Test
    void createPlayerNumberOverNumberFail() {
        List<String> input = new ArrayList<>();
        char toCharacter = 'a';
        for (int i = 0; i < 21; i++) {
            input.add(String.valueOf(i + toCharacter));
        }

        assertThatThrownBy(() -> Players.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    @DisplayName("player의 이름으로 player 를 찾아 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "hello", "crong", "jk"})
    void findByNameSuccess(String input) {
        List<String> playerNamesInput = List.of("pobi", "hello", "crong", "jk");

        Players players = Players.from(playerNamesInput);
        Player playerByFindByName = players.findByName(input);

        assertThat(playerByFindByName.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("없는 player 의 이름을 찾을 경우 예외를 반환한다.")
    void findByNameFail() {
        List<String> playerNamesInput = List.of("pobi", "hello", "crong", "jk");

        Players players = Players.from(playerNamesInput);

        assertThatThrownBy(() -> players.findByName("pob"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("없는 player 입니다.");
    }

}
