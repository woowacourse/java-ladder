package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("이름을 받아 올바르게 플레이어 일급 컬렉션을 생성한다.")
    void validCreationTest() {
        List<String> names = List.of("aru", "pobi", "woowa");
        assertDoesNotThrow(() -> new Players(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aru", "a,b,c,d,e,f,g,h,i,j,k"})
    @DisplayName("사람 수가 범위를 넘어가는 경우, 예외를 발생한다.")
    void invalidSizeCreationTest(String value) {
        // given
        String[] split = value.split(",");
        List<String> names = Arrays.stream(split).toList();
        // when, then
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여하는 사람의 수는 2명 이상 10명 이하여야 합니다.");
    }

    @Test
    @DisplayName("중복된 이름이 존재하는 경우, 예외를 발생한다.")
    void duplicatedNameTest() {
        // given
        List<String> names = List.of("aru", "aru", "pobi");
        // when, then
        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("범위를 넘어가는 경우, 예외를 발생한다.")
    void getIndexOutOfBoundTest() {
        // given
        Players players = new Players(List.of("aru", "pobi"));
        // when
        Assertions.assertThatThrownBy(() -> players.get(2))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("주어진 인덱스가 범위를 벗어납니다.");
    }

    @Test
    @DisplayName("이름으로 올바르게 인덱스를 가져온다")
    void getIndexByNameTest() {
        // given
        Players players = new Players(List.of("aru", "pobi"));
        // when
        int actual = players.getIndexByName("pobi");
        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 존재하지 않는 경우, 인덱스를 가져오려고 할 때 예외가 발생한다.")
    void getIndexByNameDoesNotExistsTest() {
        // given
        Players players = new Players(List.of("aru", "pobi"));
        // when, then
        assertThatThrownBy(() -> players.getIndexByName("woowa"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }
}
