package model;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("정상적으로 참여 인원 객체를 생성한다.")
    void createSuccess() {
        List<String> players = List.of("pobi", "anna");
        Assertions.assertThatCode(() -> new Players(players))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여 인원이 2명 미만이어서 오류가 발생한다.")
    void createUnderPlayersSize() {
        List<String> players = List.of("pobi");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여 인원이 12명 초과면 오류가 발생한다.")
    void createOverPlayersSize() {
        //given
        List<String> players = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            players.add(String.valueOf(i));
        }

        //when & then
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 이름의 참여 인원인 경우 오류를 반환한다.")
    void duplicatedPlayersName() {
        List<String> players = List.of("pobi", "pobi", "anna");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
