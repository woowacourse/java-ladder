package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.Disabled;
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

    @Test
    @Disabled("참여자 이름을 검색하여 최종결과 반환 기능 테스트 내용과 중복되므로 비활성화한다.")
    @DisplayName("사다리 타기가 완료된 참여자의 위치에 맞는 결과 저장 기능 테스트")
    void saveResultByPositionTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro, ocean"));
        List<Result> results = ResultFactory.create(players.size(), "꽝, 5000, 꽝, 3000");

        //when
        players.saveAllResults(results);

        //then
        assertThat(players.getResultOf(new Name("pobi"))).isEqualTo("꽝");
        assertThat(players.getResultOf(new Name("neo"))).isEqualTo("5000");
        assertThat(players.getResultOf(new Name("hiiro"))).isEqualTo("꽝");
        assertThat(players.getResultOf(new Name("ocean"))).isEqualTo("3000");
    }

    @Test
    @DisplayName("참여자 이름을 검색하여 최종 결과 반환 기능 테스트")
    void getResultByNameTest() {
        //given
        Players players = new Players(NameFactory.create("pobi, neo, hiiro, ocean"));
        List<Boolean> firstPoints = List.of(true, false, true);
        List<Boolean> secondPoints = List.of(false, true, false);
        List<Boolean> thirdPoints = List.of(true, false, false);
        List<Boolean> fourthPoints = List.of(true, false, true);
        List<Result> results = ResultFactory.create(players.size(), "꽝, 5000, 꽝, 3000");

        //when
        players.moveAllPlayersByLinePoints(firstPoints);
        players.moveAllPlayersByLinePoints(secondPoints);
        players.moveAllPlayersByLinePoints(thirdPoints);
        players.moveAllPlayersByLinePoints(fourthPoints);
        players.saveAllResults(results);

        //then
        assertThat(players.getResultOf(new Name("pobi"))).isEqualTo("3000");
        assertThat(players.getResultOf(new Name("neo"))).isEqualTo("꽝");
        assertThat(players.getResultOf(new Name("hiiro"))).isEqualTo("꽝");
        assertThat(players.getResultOf(new Name("ocean"))).isEqualTo("5000");
    }
}
