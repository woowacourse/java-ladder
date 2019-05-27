package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {
        @Test
        void 인덱스로_결과_인덱스_추출() {
                List<Line> lines = new ArrayList<>();

                List<Horizon> horizons1 = new ArrayList<>();
                horizons1.add(new Horizon(true));
                horizons1.add(new Horizon(horizons1.get(0), false));
                horizons1.add(new Horizon(horizons1.get(1), true));
                horizons1.add(new Horizon(horizons1.get(2), false));
                horizons1.add(new Horizon(horizons1.get(3), false));
                lines.add(new Line(horizons1));

                List<Horizon> horizons2 = new ArrayList<>();
                horizons2.add(new Horizon(false));
                horizons2.add(new Horizon(horizons2.get(0), false));
                horizons2.add(new Horizon(horizons2.get(1), true));
                horizons2.add(new Horizon(horizons2.get(2), false));
                horizons2.add(new Horizon(horizons2.get(3), false));
                lines.add(new Line(horizons2));

                List<Horizon> horizons3 = new ArrayList<>();
                horizons3.add(new Horizon(false));
                horizons3.add(new Horizon(horizons3.get(0), true));
                horizons3.add(new Horizon(horizons3.get(1), false));
                horizons3.add(new Horizon(horizons3.get(2), true));
                horizons3.add(new Horizon(horizons3.get(3), false));
                lines.add(new Line(horizons3));

                Ladder ladder = new Ladder(lines);
                assertThat(ladder.findResultTagIndexByIndex(0)).isEqualTo(2);
                assertThat(ladder.findResultTagIndexByIndex(2)).isEqualTo(1);
                assertThat(ladder.findResultTagIndexByIndex(4)).isEqualTo(3);
        }
}