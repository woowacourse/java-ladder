package player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("플레이어들의 이름으로 올바르게 생성한다.")
    void validCreationTest() {
        assertDoesNotThrow(() -> new Players(List.of("aru", "pobi", "woowa")));
    }

    @Test
    @DisplayName("플레이어들의 이름을 올바르게 가져온다.")
    void getNamesTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when
        List<String> actual = players.getNames();
        // then
        assertThat(actual).containsExactly("aru", "pobi", "woowa");
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "one,two,three,four,five,six,seven,eight,nine,ten,elevn"})
    @DisplayName("플레이어 수가 범위를 벗어나면 예외를 발생한다.")
    void invalidSizeTest(String names) {
        // given
        List<String> playerNames = List.of(names.split(","));
        // when, then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 개수는 2개 이상 10개 이하로 작성해야 합니다.");
    }

    @Test
    @DisplayName("플레이어 수를 올바르게 반환한다.")
    void playersSizeTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when, then
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어의 이름이 존재하는 인덱스를 올바르게 반환한다.")
    void findIndexByNameTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when, then
        assertThat(players.findIndexByName("aru")).isEqualTo(0);
    }

    @Test
    @DisplayName("플레이어의 이름을 찾을 때, 존재하지 않는 경우 예외를 발생한다.")
    void findIndexByNameNotFoundTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when, then
        assertThatThrownBy(() -> players.findIndexByName("jazz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }

    @Test
    @DisplayName("플레이어의 인덱스에 해당하는 이름을 올바르게 반환한다.")
    void findByIndexTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when, then
        assertThat(players.getNameByIndex(0)).isEqualTo("aru");
    }

    @Test
    @DisplayName("플레이어의 인덱스가 범위를 벗어나면 예외를 발생한다.")
    void findByIndexOutOfRangeTest() {
        // given
        Players players = new Players(List.of("aru", "pobi", "woowa"));
        // when, then
        assertThatThrownBy(() -> players.getNameByIndex(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("인덱스를 벗어납니다.");
    }

    @Test
    @DisplayName("플레이어 이름이 중복되는 경우, 예외가 발생한다.")
    void duplicatedNameTest() {
        // given
        List<String> playerNames = List.of("aru", "pobi", "aru");
        // when, then
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }
}
