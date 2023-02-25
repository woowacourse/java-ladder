package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.util.TrueGenerator;

class FootBarsTest {
    @ParameterizedTest(name = "가로 라인이 겹치는 경우는 생성할 수 없다.")
    @ValueSource(ints = {3, 10, 100})
    void createLineTest(int personCount) {
        FootBars footBars = new FootBars(new ArrayList<>());
        footBars.createFootBars(new TrueGenerator(), personCount);

        for (int i = 0; i < footBars.getFootBars().size() - 1; i++) {
            if (footBars.getFootBars().get(i) == Boolean.TRUE) {
                assertThat(footBars.getFootBars().get(i + 1)).isEqualTo(Boolean.FALSE);
            }
        }
    }
}
