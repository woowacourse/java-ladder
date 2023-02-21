package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름이 같은 Player는 equals true를 반환한다.")
    @Test
    void same_Player_name_return_true() {
        Player playerA = new Player(new Name("hi"));
        Player playerB = new Player(new Name("hi"));

        assertThat(playerA).isEqualTo(playerB);
    }

    @DisplayName("이름이 다른 Player는 equals false를 반환한다.")
    @Test
    void other_Player_name_eqauls_return_false() {
        Player playerA = new Player(new Name("hi"));
        Player playerB = new Player(new Name("bye"));

        assertThat(playerA).isNotEqualTo(playerB);
    }

    @DisplayName("이름이 같으면 true를 반환한다.")
    @Test
    void same_name_return_true() {
        // given
        Name name = new Name("name");
        Player player = new Player(name);

        // then
        assertThat(player.isSameName("name")).isTrue();
    }

    @DisplayName("이름이 다르면 false를 반환한다.")
    @Test
    void different_name_return_false() {
        // given
        Name name = new Name("name");
        Player player = new Player(name);

        // then
        assertThat(player.isSameName("differentName")).isFalse();
    }
}
