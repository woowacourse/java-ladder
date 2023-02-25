package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 없을 경우 Players 객체가 생성된다.")
    void createPlayers_Success() {
        List<String> names = List.of("gray", "encho", "pobi");
        assertThatNoException().isThrownBy(() -> new Players(names));
    }

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 있을 경우 예외가 발생한다.")
    void createPlayers_Fail() {
        List<String> names = List.of("gray", "encho", "gray");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 참여자의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("참가자 수가 2명 이상 50명 이하이면 Players 객체가 생성된다.")
    void creteNumberOfPlayers_Success() {
        List<String> names = List.of("gray", "encho", "pobi");
        assertThatNoException().isThrownBy(() -> new Players(names));
    }

    @Test
    @DisplayName("참가자 수가 2명미만 이거나 50명 초과이면 예외가 발생한다.")
    void createNumberOfPlayers_Fail() {
        List<String> names = List.of("gray");
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.");
    }

    @Test
    @DisplayName("인덱스에 해당하는 참가자 이름을 반환한다.")
    void getPlayerByIndex_Success() {
        List<String> names = List.of("gray", "encho", "pobi");

        Players players = new Players(names);
        int size = players.getSize();

        for (int index = 0; index < size; index++) {
            assertThat(players.findNameByIndex(index).getName()).isEqualTo(names.get(index));
        }
    }

    @Test
    @DisplayName("참가자 수 보다 큰 인덱스가 들어오는 경우 예외가 발생한다.")
    void getPlayerByIndex_Fail() {
        List<String> names = List.of("gray", "encho", "pobi");

        Players players = new Players(names);
        int size = players.getPlayers().size();

        assertThatThrownBy(() -> players.findNameByIndex(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수 보다 큰 인덱스가 입력 되었습니다.");
    }
}
