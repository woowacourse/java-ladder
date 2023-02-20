package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    @DisplayName("참여자들의 이름을 받아 참여자그룹 생성한다.")
    void persons() {
        Players players = new Players(List.of("1", "2", "3"));

        Assertions.assertThat(players.getPlayersName())
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("참여자들중 중복된 이름이 존재하면 예외가 발생한다.")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Players(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름입니다.");
    }

}
