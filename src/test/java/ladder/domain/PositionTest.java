package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 특정한 범위를 가지는 객체,
// 범위를 생성될 때 가지고 있고 (만들어질 때) 이후는 범위 안에서 사용
public class PositionTest {
    private final int begin = 0, end = 10;

    @Test
    void 생성자_범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Position(begin, end, begin - 1));
        assertThrows(IllegalArgumentException.class, () -> new Position(begin, end, end));
    }

//    @Test
//    void begin_(){
//
//    }
//
//    @Test
//    void end() {
//
//    }

    @Test
    void add_결과가_올바른_범위() {
        Position position = new Position(begin, end, 0);

        assertThat(position.plus(end - 1)).isEqualTo(new Position(begin, end, 0 + (end - 1)));
    }

    @Test
    void add_결과가_초과되는_범위() {
        Position position = new Position(begin, end, 0);

        assertThrows(IllegalArgumentException.class, () -> position.plus(end));
    }

}
