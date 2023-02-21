package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.mission.Mission;
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

    @Nested
    @DisplayName("미션 비교")
    class compareMissionTest {
        @Test
        void 같은_내용을_가진_미션은_같은_미션이다() {
            Mission mission1 = new Mission("꽝");
            Mission mission2 = new Mission("꽝");
            Mission mission3 = new Mission("당첨");

            assertThat(mission1).isEqualTo(mission2);
            assertThat(mission1).isNotEqualTo(mission3);
        }
    }

    @Test
    void 미션_글자수가_5글자_초과이면_예외_처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Mission("다섯글자이상"));
    }
}
