package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    @DisplayName("가로 라인은 겹칠 수 없다.")
    void isLineCannotNextToLine() {
        assertThrows(IllegalStateException.class, () -> new Line(List.of(Point.CONNECTED, Point.CONNECTED)));
    }

    @ParameterizedTest
    @MethodSource("argumentsStreamProvider")
    @DisplayName("다음 이동 방향을 결정한다.")
    void nextPosition(int nextIndex, int index) {
        int personCount = 5;
        BooleanGenerator generator = new TogleBooleanGenerator(true);
        LineGenerator lineGenerator = new LineGenerator(personCount, generator);
        Line line = new Line(lineGenerator.createPoints());
        // 라인 생성 결과
        // [CONNECTED, DISCONNECTED, DISCONNECTED, CONNECTED]

        assertEquals(nextIndex, line.nextIndex(index));
    }

    static Stream<Arguments> argumentsStreamProvider() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(0, 1),
                Arguments.of(2, 2),
                Arguments.of(4, 3),
                Arguments.of(3, 4)
        );
    }
}

class TogleBooleanGenerator implements BooleanGenerator {
    private boolean value;

    public TogleBooleanGenerator(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean generate() {
        boolean result = value;
        value = !value;
        return result;
    }
}

