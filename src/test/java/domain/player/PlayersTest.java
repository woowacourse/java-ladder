package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayersTest {
    private static final Player MANG = new Player("mang");
    private static final Player RORO = new Player("roro");

    @Test
    @DisplayName("이름이 정상적으로 생성되는가")
    void does_name_create_correctly() {
        Players players = new Players(new String[]{"mang", "roro"});

        assertAll(
                () -> assertThat(players.getSequence(MANG)).isEqualTo(0),
                () -> assertThat(players.getSequence(RORO)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("중복된 이름인가")
    void is_duplicated_names() {
        assertThatThrownBy(() -> new Players(new String[]{"mang", "mang"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
