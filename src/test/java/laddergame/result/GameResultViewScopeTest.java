package laddergame.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultViewScopeTest {
    @Test
    void should_ALL반환_when_all이입력되었을때() {
        // given
        String command = "all";

        // when
        Optional<GameResultViewScope> optionalGameResultViewScope = GameResultViewScope.from(command);

        //then
        assertThat(optionalGameResultViewScope.orElse(null)).isEqualTo(GameResultViewScope.ALL);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "", " ", "a"})
    void should_nullOptional반환_when_all이아닌값이입력되었을때(String command) {
        // given

        // when
        Optional<GameResultViewScope> optionalGameResultViewScope = GameResultViewScope.from(command);

        //then
        assertThat(optionalGameResultViewScope.isEmpty()).isTrue();
    }
}
