package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("존재하지 않는 이름의 플레이어를 검색하면 예외를 반환한다.")
    void throwExceptionWhenNotExistName() {
        Players players = new Players(List.of("pobi", "crong"));
        assertThatThrownBy(() -> new Result("eddy", players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 플레이어 이름입니다.");
    }

    @Test
    @DisplayName("실행 결과에서 all을 입력하면 모든 플레이어 이름의 목록을 반환한다.")
    void validResultUsingAllCommand() {
        // given
        String input = "all";
        Players players = new Players(List.of("pobi", "crong"));
        List<String> expected = List.of("pobi", "crong");

        // when
        Result result = new Result(input, players);
        List<String> actual = result.getNames();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("실행 결과에서 특정 플레이어를 입력하면 해당 플레이어만 가진 목록을 반환한다.")
    void validPlayerUsingSpecificName() {
        // given
        String input = "crong";
        Players players = new Players(List.of("pobi", "crong"));
        List<String> expected = List.of("crong");

        // when
        Result result = new Result(input, players);
        List<String> actual = result.getNames();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}


