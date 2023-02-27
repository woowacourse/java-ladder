package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("여러 개의 이름을 입력받고 players를 생성한다")
    void shouldCreatePlayersWhenInputStrings() {
        //given
        String namesRaw = "a,ab,abc";
        //when
        //then
        assertDoesNotThrow(() -> new Players(namesRaw));
    }

    @Test
    @DisplayName("플레이어의 수를 반환한다")
    void shouldReturnSizeWhenRequest() {
        //given
        String namesRaw = "a,ab,abc";
        //when
        Players players = new Players(namesRaw);
        //then
        assertThat(players.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어들의 이름을 문자열로 반환한다")
    void shouldReturnNameValuesWhenRequest() {
        //given
        String namesRaw = "a,ab,abc";
        //when
        Players players = new Players(namesRaw);
        //then
        assertThat(players.getNameValues()).containsExactly("a", "ab", "abc");
    }

    @Test
    @DisplayName("플레이어는 2명 이상이여야 한다")
    void shouldMinimum2PlayersWhenCreate() {
        //given
        String namesRaw = "a";
        //when
        //then
        assertThatThrownBy(() -> new Players(namesRaw))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 최소 2명 이상이여야 합니다");
    }

    @Test
    @DisplayName("이름을 입력 받아 해당하는 플레이어를 반환한다.")
    void shouldReturnAppropriatePlayerWhenInputName() {
        String namesRaw = "a,ab,abc";
        Players players = new Players(namesRaw);
        Player player = players.getPlayerByName("abc");
        assertThat(player.getNameValue()).isEqualTo("abc");
    }

    @Test
    @DisplayName("입력받은 이름의 플레이어가 없으면 예외가 발생한다.")
    void shouldThrowExceptionWhenInputNameNotExist() {
        String namesRaw = "a,ab,abc";
        Players players = new Players(namesRaw);
        assertThatThrownBy(() -> players.getPlayerByName("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 플레이어의 이름입니다.");
    }

    @Test
    @DisplayName("중복된 이름의 플레이어를 생성하면 예외가 발생한다.")
    void shouldThrowExceptionWhenInputDuplicatedName() {
        String namesRaw = "a,b,a,d";
        assertThatThrownBy(() -> new Players(namesRaw))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("너무 긴 길이의 이름을 넣으면 예외를 발생한다")
    void shouldThrowExceptionWhenWrongLength() {
        assertThatThrownBy(() -> new Player("abcdef", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백을 넣으면 예외를 발생한다")
    @NullSource
    void shouldThrowExceptionWhenBlank(String input) {
        assertThatThrownBy(() -> new Player(input, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백일 수 없습니다.");
    }
}
