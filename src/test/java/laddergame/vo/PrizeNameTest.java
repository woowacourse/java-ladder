package laddergame.vo;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeNameTest {
    @Nested
    class 생성기능 {
        @ParameterizedTest
        @ValueSource(strings = {""})
        void test_생성자_should_예외를던진다_when_이름의길이가맞지않을때(String name) {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new PrizeName(name);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("상품 이름 길이는 1이상이어야합니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc ", "  ", "a b", " abc"})
        void test_생성자_should_예외를던진다_when_이름에공백이있을때(String name) {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new PrizeName(name);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("상품 이름에는 공백이 포함될 수 없습니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"꽝", "500000", "오천원"})
        void test_생성자_should_정상생성_when_예외상황이아닌경우(String name) {
            // given

            // when
            ThrowingCallable throwingCallable = () -> new PrizeName(name);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }
}
