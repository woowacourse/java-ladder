package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest extends AbstractTestFixture {

    @Test
    @DisplayName("사다리의 높이가 양수가 아니면 IllegalArgumentException를 던진다")
    void test_LineHeight_IllegalArgumentException() {
        //when & then
        assertThatThrownBy(() -> new Line(createBridges(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 양수만 가능합니다");
    }

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_LineHeight_success(int height) {
        //given
        List<Bridge> bridges = createBridges(height);

        //when & then
        assertThatNoException().isThrownBy(
                () -> new Line(bridges)
        );
    }

    @Test
    @DisplayName("시작점을 정하면 사다리를 타고 목적지에 갈 수 있다.")
    void test_moveRightBridge_increaseOnce() throws Exception {
        //given
        List<Bridge> bridges = List.of(
                new Bridge(convert(true, false, true)),
                new Bridge(convert(false, true, false)),
                new Bridge(convert(true, false, false)),
                new Bridge(convert(false, true, false)),
                new Bridge(convert(true, false, true))
        );

        //when
        Line line = new Line(bridges);

        int firstStart = line.move(0);
        int secondStart = line.move(1);
        int thirdStart = line.move(2);
        int fourthStart = line.move(3);

        //then

//      |-----|     |-----|
//      |     |-----|     |
//      |-----|     |     |
//      |     |-----|     |
//      |-----|     |-----|

        assertAll(
                () -> assertEquals(firstStart, 0),
                () -> assertEquals(secondStart, 3),
                () -> assertEquals(thirdStart, 2),
                () -> assertEquals(fourthStart, 1)
        );
    }
}
