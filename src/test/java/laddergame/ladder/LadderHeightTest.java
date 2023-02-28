package laddergame.ladder;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {
    @Nested
    class 생성기능 {
        @Test
        void test_생성자_should_예외를던진다_when_높이가1이하인경우() {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new LadderHeight(1);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("높이가 2이상이어야 합니다.");
        }

        @Test
        void test_생성자_should_정상생성_when_높이가2이상인경우() {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new LadderHeight(2);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }
}
