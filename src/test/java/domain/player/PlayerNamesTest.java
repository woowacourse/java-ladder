package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNamesTest {

    @DisplayName("참가자의 수가 2명 이상 10명 이하이면 객체가 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3,4,5,6,7,8,9,10"})
    void createPlayerNames(String playerNamesBundle) {
        //given
        final String[] playerNames = playerNamesBundle.split(",");

        // when & then
        assertThatCode(() -> PlayerNames.from(List.of(playerNames)))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 수가 2명 미만 10명 초과이면 객체 생성시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7,8,9,10,11"})
    void invalidPlayerCount(String playerNamesBundle) {
        //given
        final String[] playerNames = playerNamesBundle.split(",");

        // when & then
        assertThatThrownBy(() -> PlayerNames.from(List.of(playerNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름의 참가자가 존재하면 예외가 발생한다.")
    @Test
    void duplicatedNames() {
        //given & when & then
        assertThatThrownBy(() -> PlayerNames.from(List.of("a", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 참가자의 이름을 반환한다.")
    @Test
    void returnPlayerNamesAll() {
        //given
        final List<String> rawNames = List.of("a", "b");
        final PlayerNames playerNames = PlayerNames.from(rawNames);

        // when
        final List<String> values = playerNames.getValues();

        // then
        assertThat(values).containsExactlyElementsOf(rawNames);
    }
}
