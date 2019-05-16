package ladder.domain;

import com.sun.tools.javac.sym.CreateSymbols;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrossbarsTest {
    @Test
    void crossbars가_제대로_생성되는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false, true, false);

        assertThat(new Crossbars(crossbars)).isEqualTo(new Crossbars(crossbars));
    }

    @Test
    void crossbar_크기가_2보다_작으면_예외를_던지는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false);

        assertThrows(IllegalArgumentException.class, () -> new Crossbars(crossbars));
    }

    @Test
    void crossbars에_연속된_crossbar가_있는_경우_예외를_던지는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false, true, true, false);

        assertThrows(IllegalArgumentException.class, () -> new Crossbars(crossbars));
    }

    @Test
    void Dummy_자리인_첫번째와_마지막_자리에는_crossbar가_있으면_예외를_던지는지_테스트() {
        List<Boolean> crossbars1 = Arrays.asList(true, false, false);
        List<Boolean> crossbars2 = Arrays.asList(false, true, true);

        assertThrows(IllegalArgumentException.class, () -> new Crossbars(crossbars1));
        assertThrows(IllegalArgumentException.class, () -> new Crossbars(crossbars2));
    }

    @Test
    void 크로스바에_시작_위치를_입력했을_때_결과_위치를_제대로_알려주는지_테스트() {
        Crossbars crossbars = new Crossbars(Arrays.asList(false, false, true, false)); // 이렇게 생겼음 :   |     |-----|

        assertThat(crossbars.answerResultIndexOf(0)).isEqualTo(0);
        assertThat(crossbars.answerResultIndexOf(1)).isEqualTo(2);
        assertThat(crossbars.answerResultIndexOf(2)).isEqualTo(1);
    }
}
