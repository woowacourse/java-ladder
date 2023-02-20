package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class PlayersTest {
    private static Stream<Arguments> provideFailPlayerNames() {
        return Stream.of(Arguments.of(List.of("a")),
                Arguments.of(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n")),
                Arguments.of(List.of()));
    }

    private static Stream<Arguments> provideSuccessPlayerNames() {
        return Stream.of(Arguments.of(List.of("a", "b")),
                Arguments.of(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l")));
    }

    @DisplayName("player 수 Fail 테스트")
    @ParameterizedTest
    @MethodSource("provideFailPlayerNames")
    void player_count_fail(List<String> input) {
        assertThatThrownBy(() -> new Players(input)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("player 수 성공 테스트")
    @ParameterizedTest
    @MethodSource("provideSuccessPlayerNames")
    void player_count_success(List<String> input) {
        assertThatNoException().isThrownBy(() -> new Players(input));
    }

    @DisplayName("플레이어 이름이 중복될 때")
    @Test
    void duplicateName() {
        assertThatThrownBy(() -> {
            new Players(List.of("aaaa", "aaaa"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름의 최대길이 구하기")
    @Test
    void maxName() {
        Players players = new Players(List.of("aaa", "bbbb"));
        assertThat(players.getMaxPlayerNameLength()).isEqualTo(4);
    }

    @Nested
    @DisplayName("플레이어 이름 길이 테스트")
    class nameLength {
        @DisplayName("사용자의 이름의 길이가 5초과 일때 에러 확인")
        @Test
        void namelength1() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobiss", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자 이름의 길이가 0 일때 에러 확인")
        @Test
        void namelength2() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobi", "", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자 이름이 공백 일때 에러 확인")
        @Test
        void namelength3() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobi", "      ", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
