package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.util.TrueGenerator;

class FootBarsMakerTest {
    @ParameterizedTest(name = "가로 라인이 겹치는 경우는 생성할 수 없다.")
    @ValueSource(ints = {3, 10, 100})
    void createLineTest(int personCount) {
        List<Boolean> footBars = FootBarsMaker.makeFootBars(new TrueGenerator(), personCount).getFootBars();
        for (int i = 0; i < footBars.size() - 1; i++) {
            if (footBars.get(i) == Boolean.TRUE) {
                assertThat(footBars.get(i + 1)).isEqualTo(Boolean.FALSE);
            }
        }
    }
}
