package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrosspointsTest {
    @Test
    void crossbars가_제대로_생성되는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false, true, false);

        assertThat(new Crosspoints(new Crossbar(crossbars))).isEqualTo(new Crosspoints(new Crossbar(crossbars)));
    }

    @Test
    void 크로스바에_시작_위치를_입력했을_때_결과_위치를_제대로_알려주는지_테스트() {
        Crosspoints crosspoints = new Crosspoints(new Crossbar(Arrays.asList(false, false, true, false))); // 이렇게 생겼음 :   |     |-----|

        assertThat(crosspoints.answerResultIndexOf(0)).isEqualTo(0);
        assertThat(crosspoints.answerResultIndexOf(1)).isEqualTo(2);
        assertThat(crosspoints.answerResultIndexOf(2)).isEqualTo(1);
    }

    @Test
    void CrossPoints의_사이즈를_잘_반환해_주는지_테스트() {
        List<Boolean> crossbars = Arrays.asList(false, true, false);

        assertThat(new Crosspoints(new Crossbar(crossbars)).width()).isEqualTo(2);
    }
}
