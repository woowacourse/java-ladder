package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
        @Test
        void 라인_생성_검사() {
                List<Horizon> horizons = new ArrayList<>();
                horizons.add(new Horizon(true));
                horizons.add(new Horizon(horizons.get(0), false));
                horizons.add(new Horizon(horizons.get(1), true));
                horizons.add(new Horizon(horizons.get(2), false));
                assertThat(new Line(horizons).getHorizons()).isEqualTo(horizons);
        }

        @Test
        void 입력_인덱스로_라인_이동_후_인덱스_추출_검사() {
                List<Horizon> horizons = new ArrayList<>();
                horizons.add(new Horizon(true));
                horizons.add(new Horizon(horizons.get(0), false));
                horizons.add(new Horizon(horizons.get(1), true));
                horizons.add(new Horizon(horizons.get(2), false));
                assertThat(new Line(horizons).getIndexAfterMovingHorizon(2)).isEqualTo(3);
        }
}