package laddergame.result;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PrizesTest {
    Prizes prizes = Prizes.from(List.of(
            "0",
            "1",
            "2"
    ), 3);

    @Nested
    class 생성기능 {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 4, 5, 6, 0, -1})
        void test_from_should_예외를던진다_when_결과갯수가예상된갯수와다를때(int expectedCount) {
            // given
            List<String> results = List.of("a", "b", "c");

            // when
            ThrowingCallable throwingCallable = () -> Prizes.from(results, expectedCount);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("결과의 개수가 플레이어의 수와 일치하지 않습니다.");
        }

        @Test
        void test_from_should_정상생성_when_예외상황이아닐때() {
            // given
            List<String> results = List.of("a", "b", "c");

            // when
            ThrowingCallable throwingCallable = () -> Prizes.from(results, 3);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }

    @Nested
    class 특정위치의상품이름찾는기능 {
        @Test
        void test_getPrizeName_should_상품을반환한다_when_위치를넣으면() {
            // given
            int position = 0;

            // when
            String prize = prizes.getPrizeName(position);

            //then
            assertThat(prize).isEqualTo("0");
        }
    }
}
