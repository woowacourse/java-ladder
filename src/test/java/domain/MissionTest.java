package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionTest {

    @Nested
    @DisplayName("미션 생성 테스트")
    class createMissionTest {
        @ParameterizedTest
        @ValueSource(strings = {"꽝", "5000", "3000"})
        void 미션_생성_값_입력(String input) {
            Mission mission = new Mission(input);
            Assertions.assertEquals(mission.getMission(), input);
        }

        @Test
        void 미션_글자수가_5글자_초과이면_예외_처리() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Mission("다섯글자이상"));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        void 공백으로_생성시_예외_처리(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Mission(input));
        }
    }
}
