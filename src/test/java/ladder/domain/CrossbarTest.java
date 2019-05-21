package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrossbarTest {
    @Test
    void 크로스바의_사이즈가_2이하이면_예외를_던지는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false);
        assertThrows(IllegalArgumentException.class, () -> new Crossbar(crossbars));
    }

    @Test
    void 크로스바의_시작과_끝이_false가_아니면_예외를_던지는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(true, false);
        assertThrows(IllegalArgumentException.class, () -> new Crossbar(crossbars));
    }

    @Test
    void 크로스바의_왼쪽과_오른쪽을_확인하여_Crosspoints를_제대로_만드는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false, true, false);
        List<Crosspoint> crosspoints = Arrays.asList(new Crosspoint(false, true),
                new Crosspoint(true, false));
        Crossbar crossbar = new Crossbar(crossbars);

        assertThat(crossbar.getCrosspoints()).isEqualTo(crosspoints);
    }
}
