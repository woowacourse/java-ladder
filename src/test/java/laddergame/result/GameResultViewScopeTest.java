package laddergame.result;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultViewScopeTest {
    @Nested
    class 커맨드변환기능 {
        @Test
        void test_from_should_ALL반환_when_all이입력되었을때() {
            // given
            String command = "all";

            // when
            Optional<GameResultViewScope> optionalGameResultViewScope = GameResultViewScope.from(command);

            //then
            assertThat(optionalGameResultViewScope.orElse(null)).isEqualTo(GameResultViewScope.ALL);
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "", " ", "a"})
        void test_from_should_nullOptional반환_when_all이아닌값이입력되었을때(String command) {
            // given

            // when
            Optional<GameResultViewScope> optionalGameResultViewScope = GameResultViewScope.from(command);

            //then
            assertThat(optionalGameResultViewScope.isEmpty()).isTrue();
        }
    }
}
