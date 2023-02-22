package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @Test
    @DisplayName("List<String>이 입력되면 Players 객체를 생성한다.")
    void givenStringList_thenCreateNames() {
        //given
        final List<String> names = List.of("에단", "준팍");

        //when
        final Players result = Players.from(names);

        //then
        assertThat(result.getPlayerName()).isEqualTo(names);
    }

    @Test
    @DisplayName("List<String>의 길이가 2미만이면 예외를 발생한다.")
    void givenTwoUnderStringListSize_thenFail() {
        //given
        final List<String> wrongSizeList = List.of("에단");

        //then
        assertThatThrownBy((() -> Players.from(wrongSizeList)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2명 이상의 플레이어가 필요합니다.");
    }

    @Test
    @DisplayName("가장 긴 이름의 길이를 반환한다.")
    void givenNames_thenReturnMaxNameLength() {
        //given
        final List<String> names = List.of("에단", "준팍", "블랙캣");
        final Players players = Players.from(names);

        //when
        final int maxNameLength = players.findMaxNameLength();

        //then
        assertThat(maxNameLength).isEqualTo("블랙캣".length());
    }


}
