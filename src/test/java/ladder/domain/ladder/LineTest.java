package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    @DisplayName("addBars()은 사람수 +1 만큼 생성된다.")
    void test_1() {
        // when
        line.addBars(4, () -> Bar.of(true));

        // then
        assertThat(line.getBars().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("addBars()은 랜덤 값이 false로 나올 때, 생성되는 bars의 값은 모두 false이다.")
    void test_2() {
        // given
        List<Bar> expected = List.of(Bar.FALSE, Bar.FALSE, Bar.FALSE, Bar.FALSE, Bar.FALSE);

        // when
        line.addBars(4, () -> Bar.FALSE);

        // then
        assertThat(line.getBars()).isEqualTo(expected);
    }

    @Test
    @DisplayName("addBars()은 앞에 bar가 true일때 뒤에 bar는 무조건 false가 와야한다.")
    void test_3() {
        // given
        List<Bar> expected = List.of(Bar.FALSE, Bar.TRUE, Bar.FALSE, Bar.TRUE, Bar.FALSE);

        // when
        line.addBars(4, () -> Bar.of(true));

        // then
        assertThat(line.getBars()).isEqualTo(expected);
    }

    @Test
    @DisplayName("addBars()은 맨앞, 맨 뒤의 bar는 무조건 false 이어야 한다.")
    void test_4() {
        // when
        line.addBars(4, () -> Bar.of(true));

        // then
        assertThat(line.getBars().get(0)).isEqualTo(Bar.FALSE);
        assertThat(line.getBars().get(4)).isEqualTo(Bar.FALSE);
    }
}

