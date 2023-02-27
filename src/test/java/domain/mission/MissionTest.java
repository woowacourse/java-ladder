package domain.mission;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("입력값에 따라 미션을 생성할 수 있다.")
    @Nested
    class createMissionTest {
        @DisplayName("정상 입력 시 미션을 생성한다.")
        @ParameterizedTest
        @ValueSource(strings = {"꽝", "5000", "3000"})
        void validInputTest(String input) {
            Mission mission = new Mission(input);
            Assertions.assertEquals(mission.getMission(), input);
        }

        @DisplayName("부적절한 입력값으로는 미션을 생성할 수 없다.")
        @Nested
        class invalidInputTest {
            @DisplayName("다섯 글자 이상은 미션을 생성할 수 없다.")
            @Test
            void tooLongInputTest() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Mission("다섯글자이상"));
            }

            @DisplayName("공백은 미션을 생성할 수 없다.")
            @ParameterizedTest
            @ValueSource(strings = {"", " "})
            void emptySourceTest(String input) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Mission(input));
            }

            @DisplayName("null 값은 미션을 생성할 수 없다.")
            @Test
            void nullSourceTest() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Mission(null));
            }
        }
    }

    @DisplayName("같은 이름을 가진 미션은 같은 미션이다.")
    @Nested
    class compareMissionTest {
        @Test
        void compareMissionTest() {
            Mission mission1 = new Mission("꽝");
            Mission mission2 = new Mission("꽝");
            Mission mission3 = new Mission("당첨");

            assertThat(mission1).isEqualTo(mission2);
            assertThat(mission1).isNotEqualTo(mission3);
        }
    }
}
