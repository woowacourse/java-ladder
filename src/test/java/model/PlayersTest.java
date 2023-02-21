package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayersTest {
    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createPlayersTest() {
        assertThatNoException().isThrownBy(() -> new Players(NameFactory.create("pobi, neo, hiiro")));
    }

    @Test
    @DisplayName("사다리 게임 전체 참여자 명단을 반환하는 기능 테스트")
    void getAllPlayerNamesTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro"));

        //when
        List<String> result = players.getAllPlayerNames();

        //then
        assertThat(result).isEqualTo(List.of("pobi", "neo", "hiiro"));
    }

    @Test
    @DisplayName("참여자의 이름을 통해 해당 참여자의 정보를 검색하는 기능 테스트")
    void findPlayerByNameTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro"));

        //when
        Player result = players.findPlayerByName(new Name("hiiro"));

        //then
        assertThat(result.getName()).isEqualTo("hiiro");
    }
}
