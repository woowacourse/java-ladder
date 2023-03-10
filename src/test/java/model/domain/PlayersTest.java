package model.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import model.vo.Name;
import model.vo.Result;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersTest {
    private static final String NO_PLAYER_NAME_ERROR = "[ERROR] 해당 이름의 플레이어는 존재하지 않습니다.";

    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createPlayersTest() {
        assertThatNoException().isThrownBy(() -> new Players(List.of(new Name("pobi"), new Name("neo"), new Name("hiiro"))));
    }

    @Test
    @DisplayName("사다리 게임 전체 참여자 명단을 반환하는 기능 테스트")
    void getAllPlayerNamesTest() {
        //given
        Players players = new Players(List.of(new Name("pobi"), new Name("neo"), new Name("hiiro")));

        //when
        List<Name> names = players.getAllPlayerNames();
        List<String> result = names.stream()
                .map(Name::getName)
                .collect(Collectors.toList());

        //then
        assertThat(result).isEqualTo(List.of("pobi", "neo", "hiiro"));
    }

    @Test
    @DisplayName("사다리 라인에 따라 참여자 현재 위치를 바꾸는 기능 테스트")
    void moveAllPlayersByLinePointsTest() {
        //given
        Players players = new Players(List.of(new Name("pobi"), new Name("neo"), new Name("hiiro"), new Name("ocean")));
        List<List<Boolean>> givenLines = List.of(List.of(true, false, true), List.of(false, true, false),
                List.of(true, false, false), List.of(true, false, true));

        //when
        givenLines.forEach(players::moveAllPlayersByLinePoints);

        List<Name> names = players.getAllNamesOrderedByPosition();
        List<String> result = names.stream()
                .map(Name::getName)
                .collect(Collectors.toList());

        //then
        assertThat(result).isEqualTo(List.of("neo", "ocean", "hiiro", "pobi"));
    }

    @Test
    @Disabled("참여자 이름을 검색하여 최종결과 반환 기능 테스트 내용과 중복되므로 비활성화한다.")
    @DisplayName("사다리 타기가 완료된 참여자의 위치에 맞는 결과 저장 기능 테스트")
    void saveResultByPositionTest() {}

    @Test
    @DisplayName("참여자 이름을 검색하여 최종 결과 반환 기능 테스트")
    void getResultByNameTest() {
        //given
        Players players = new Players(List.of(new Name("pobi"), new Name("neo"), new Name("hiiro"), new Name("ocean")));
        List<List<Boolean>> givenLines = List.of(List.of(true, false, true), List.of(false, true, false),
                List.of(true, false, false), List.of(true, false, true));
        List<Result> results = List.of(new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"));

        //when
        givenLines.forEach(players::moveAllPlayersByLinePoints);
        players.saveAllResults(results);

        Result pobiResult = players.getResultOf(new Name("pobi"));
        Result neoResult = players.getResultOf(new Name("neo"));
        Result hiiroResult = players.getResultOf(new Name("hiiro"));
        Result oceanResult = players.getResultOf(new Name("ocean"));

        //then
        assertThat(pobiResult.getResult()).isEqualTo("3000");
        assertThat(neoResult.getResult()).isEqualTo("꽝");
        assertThat(hiiroResult.getResult()).isEqualTo("꽝");
        assertThat(oceanResult.getResult()).isEqualTo("5000");
    }

    @Test
    @DisplayName("존재하지 않는 이름을 검색한 경우 예외 처리 기능 테스트")
    void throwExceptionNoNameErrorTest() {
        //given
        Players players = new Players(List.of(new Name("pobi"), new Name("neo"), new Name("hiiro"), new Name("ocean")));
        List<Result> results = List.of(new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"));

        //when
        players.saveAllResults(results);

        //then
        assertThatThrownBy(() -> players.getResultOf(new Name("kevin")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_PLAYER_NAME_ERROR);
    }
}
