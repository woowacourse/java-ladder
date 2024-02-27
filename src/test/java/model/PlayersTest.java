package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayersTest {
    @Test
    @DisplayName("정상적으로 참여 인원 객체를 생성한다.")
    void createSuccess() {
        List<String> players = List.of("pobi", "anna");
        Assertions.assertThatCode(() -> new Players(players))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여 인원이 2명 미만이어서 오류가 발생한다.")
    void createUnderPlayersSize() {
        List<String> players = List.of("pobi");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여 인원이 12명 초과면 오류가 발생한다.")
    void createOverPlayersSize() {
        //given
        List<String> players = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            players.add(String.valueOf(i));
        }

        //when & then
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("중복된 이름의 참여 인원인 경우 오류를 반환한다.")
    void duplicatedPlayersName() {
        List<String> players = List.of("pobi", "pobi", "anna");
        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("createFormatPlayersParametersProvider")
    @DisplayName("이름 사이에 공백을 패딩하여 반환한다.")
    void createFormatPlayers(List<String> rawNames, String expected) {
        //give & when
        Players players = new Players(rawNames);

        //then
        Assertions.assertThat(players.format()).isEqualTo(expected);
    }

    static Stream<Arguments> createFormatPlayersParametersProvider() {
        return Stream.of(
                Arguments.of(List.of("anna", "redy", "brown", "pobi"), "anna   redy brown pobi"),
                Arguments.of(List.of("pobi", "honux", "crong", "jk"), "pobi  honux crong   jk")
        );
    }
}
