package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class HeightTest {

    @Nested
    class 생성자_테스트 {

        @Test
        void 인자로_0_이하의_값이_주어지면_예외가_발생한다() {
            assertThatThrownBy(() -> new Height(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("사다리 높이는 최소 1 이상이어야 합니다.");
        }

        @Test
        void 인자로_1_이상의_값이_주어지면_Height를_생성한다() {
            assertThatCode(() -> new Height(1)).doesNotThrowAnyException();
        }
    }

    @Nested
    class isContinueMakerLadder_메소드_테스트 {

        private final Height height = new Height(5);

        @Test
        void 원시_값_height가_전달한_매개변수보다_크면_true를_반환한다() {
            boolean actual = height.isContinueMakeLadder(4);

            assertThat(actual).isSameAs(true);
        }

        @Test
        void 원시_값_height가_전달한_매개변수보다_작으면_false를_반환한다() {
            boolean actual = height.isContinueMakeLadder(5);

            assertThat(actual).isSameAs(false);
        }
    }
}
