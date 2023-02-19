package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
