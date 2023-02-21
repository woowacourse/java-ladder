package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayersTest {
    private static final String NO_PLAYER_NAME_ERROR = "[ERROR] 해당 이름의 플레이어는 존재하지 않습니다.";

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

    @Test
    @DisplayName("존재하지 않는 이름을 검색한 경우 예외 처리하는 기능 테스트")
    void throwExceptionWhenFindWithNoNameTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro"));

        //then
        assertThatThrownBy(() -> players.findPlayerByName(new Name("abcde")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_PLAYER_NAME_ERROR);
    }
}
