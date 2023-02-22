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
    @DisplayName("사다리 라인에 따라 참여자 현재 위치를 바꾸는 기능 테스트")
    void moveAllPlayersByLinePointsTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro, ocean"));
        List<Boolean> firstPoints = List.of(true, false, true);
        List<Boolean> secondPoints = List.of(false, true, false);
        List<Boolean> thirdPoints = List.of(true, false, false);
        List<Boolean> fourthPoints = List.of(true, false, true);

        //when
        players.moveAllPlayersByLinePoints(firstPoints);
        players.moveAllPlayersByLinePoints(secondPoints);
        players.moveAllPlayersByLinePoints(thirdPoints);
        players.moveAllPlayersByLinePoints(fourthPoints);

        //then
        assertThat(players.getAllNamesOrderedByPosition()).isEqualTo(List.of("neo", "ocean", "hiiro", "pobi"));
    }
}
