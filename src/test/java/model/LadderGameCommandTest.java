package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderGameCommandTest {

    private final LadderGameCommand command = LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND;

    @Nested
    class isPlayable_메소드_테스트 {

        @ParameterizedTest
        @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
        void DEFAULT_COMMAND는_all이_아닌_값을_전달하면_true를_반환한다(String name) {
            boolean actual = command.isPlayable(name);

            assertThat(actual).isTrue();
        }

        @Test
        void DEFAULT_COMMAND는_all을_전달하면_false를_반환한다() {
            boolean actual = command.isPlayable("all");

            assertThat(actual).isFalse();
        }
    }
}
