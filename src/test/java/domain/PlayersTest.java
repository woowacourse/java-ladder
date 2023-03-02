package domain;


import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("플레이어의 이름이 중복되면 예외를 반환한다.")
    @Test
    void create_fail_with_duplicate_name() {
        //given
        List<Name> names = List.of(new Name("중복"), new Name("중복"));
        AtomicInteger index = new AtomicInteger();
        List<Player> players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 이름은 중복될 수 없습니다.");
    }

    @DisplayName("플레이어가 두 명 이하면 예외를 반환한다.")
    @Test
    void create_fail_with_less_than_two_player() {
        //given
        List<Name> names = Collections.emptyList();
        AtomicInteger index = new AtomicInteger();
        List<Player> players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(Collectors.toList());

        //when

        //then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어는 두 명 이상이어야 합니다.");
    }

    @DisplayName("없는 이름으로 플레이어를 찾으려 할 경우 예외를 반환한다.")
    @Test
    void find_fail_with_wrong_player_name() {
        //given
        List<Name> names = List.of(new Name("있는"), new Name("이름"));
        AtomicInteger index = new AtomicInteger();
        Players players = names.stream()
                .map(name -> new Player(name, new Position(index.getAndIncrement())))
                .collect(collectingAndThen(toList(), Players::new));

        //when

        //then
        assertThatThrownBy(() -> players.getPlayerByName("없는이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어 목록에 존재하지 않는 이름입니다.");
    }

}
