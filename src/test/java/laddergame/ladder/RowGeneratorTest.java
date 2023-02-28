package laddergame.ladder;

import laddergame.RandomBooleanGenerator;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class RowGeneratorTest {

    @Nested
    class Row생성기능 {
        @Test
        void test_generate_should_width에맞는Row생성_when_width가주어졌을때() {
            // given
            RandomBooleanGenerator booleanGenerator = new RandomBooleanGenerator();
            RowGenerator rowGenerator = new RowGenerator(booleanGenerator);
            int width = 1;

            // when

            //then
            assertAll(
                    () -> assertThatNoException()
                            .isThrownBy(() -> rowGenerator.generate(width)),
                    () -> assertThat(rowGenerator.generate(width)
                                                 .getWidth())
                            .isEqualTo(width)
            );
        }

        @Test
        void test_generate_should_예외생성_when_width가음수일때() {
            // given
            RandomBooleanGenerator booleanGenerator = new RandomBooleanGenerator();
            RowGenerator rowGenerator = new RowGenerator(booleanGenerator);
            int width = -1;

            // when
            ThrowingCallable throwingCallable = () -> rowGenerator.generate(width);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 너비가 맞지 않습니다.");
        }
    }
}