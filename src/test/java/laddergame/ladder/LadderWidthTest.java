package laddergame.ladder;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderWidthTest {
    @Nested
    class 생성기능 {
        @Test
        void test_생성자_should_예외를던진다_when_너비가0이하인경우() {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new LadderWidth(0);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("너비가 1 이상이어야 한다.");
        }

        @Test
        void test_생성자_should_정상생성_when_너비가1이상인경우() {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new LadderWidth(1);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }
}
