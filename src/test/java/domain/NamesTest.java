package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {

    @DisplayName("참가자 수가 2명 이상, 10명 이하이면 참가자 목록이 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    void createPlayers(int playerCount) {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            names.add(String.valueOf(i));
        }

        //when
        final Names players = new Names(names);

        //then
        assertThat(players.count()).isEqualTo(playerCount);
    }

    @DisplayName("참가자 수가 2명 미만, 10명 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void invalidPlayersCount(int playerCount) {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            names.add(String.valueOf(i));
        }

        //when & then
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Names.INVALID_NAMES_COUNT);
    }

    @DisplayName("중복된 참가자 이름이 존재하면 예외를 던진다.")
    @Test
    void duplicatedNames() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "crong", "jk");

        //when & then
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Names.DUPLICATED_NAMES);
    }

    @DisplayName("참가자의 수를 반환한다.")
    @Test
    void getPlayersCount() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");

        //when
        final Names players = new Names(names);
        int playersCount = players.count();
        //then
        assertThat(playersCount).isEqualTo(names.size());
    }

    @DisplayName("참가자들의 이름 목록을 반환한다.")
    @Test
    void getPlayerNames() {
        //given
        final List<String> rawNames = List.of("pobi", "honux", "crong", "jk");
        final Names names = new Names(rawNames);

        //when
        List<Name> returnedNames = names.getValues();

        //then
        assertThat(returnedNames).hasSize(4);
    }

    @DisplayName("주어진 위치에 있는 이름을 반환한다.")
    @Test
    void findNameAtIndex() {
        //given
        final List<String> rawNames = List.of("pobi", "honux", "crong", "jk");
        final Names names = new Names(rawNames);
        final int index = 2;
        final String expectedName = "crong";

        //when
        Name name = names.findAtIndex(index);

        //then
        assertThat(name.getValue()).isEqualTo(expectedName);
    }
}
