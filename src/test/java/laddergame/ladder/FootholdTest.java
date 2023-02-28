package laddergame.ladder;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FootholdTest {
    @Nested
    class 생성기능 {
        @ParameterizedTest
        @CsvSource({"true,PASSABLE", "false,BLOCKED"})
        void test_from_should_정상생성_when_boolean값이주어진경우(boolean state, Foothold expected) {
            // given

            // when
            Foothold actual = Foothold.from(state);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

}
