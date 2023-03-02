package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {
    @Test
    @DisplayName("참여자들의 이름을 받아 참여자그룹 생성한다.")
    void createPlayers() {
        Players players = new Players(List.of("1", "2", "3"));

        assertThat(players.getNames())
                .containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("참여자들중 중복된 이름이 존재하면 예외가 발생한다.")
    void validateDuplicateName() {
        assertThatThrownBy(() -> new Players(List.of("a", "b", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름입니다.");
    }

    @DisplayName("참여자들의 수가 2이상 100이하가 아닌경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 101})
    void validateNumberOfPlayers(int numberOfPlayers) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            names.add(i + "");
        }

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 수는 2부터 100까지 입니다.");
    }

    @DisplayName("플레이어의 인덱스 가져오기")
    @Test
    void getOrder() {
        Players players = new Players(List.of("a", "b", "c", "d"));

        assertThat(players.getOrder("c")).isEqualTo(2);
    }

    @DisplayName("플레이어의 인덱스 가져올떄 해당되는 이름이 존재하지 않는경우 예외 발생")
    @Test
    void createExceptionWhenCanNotFindName() {
        Players players = new Players(List.of("a", "b", "c", "d"));

        assertThatThrownBy(() -> players.getOrder("e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 참여자가 존재하지 않습니다.");
    }

}
