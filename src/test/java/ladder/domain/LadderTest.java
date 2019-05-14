package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 사다리결과테스트() {
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(true,false)),
                                        new Line(Arrays.asList(false, true)),
                                        new Line(Arrays.asList(true, false)));
        Map<String, Integer> positions = new HashMap<>();
        positions.put("pobi", 0);
        positions.put("crong", 1);
        positions.put("honux", 2);

        Map<String, Integer> result = Ladder.goDown(lines, positions);

        Map<String, Integer> answer = new HashMap<>();
        answer.put("pobi", 2);
        answer.put("crong", 1);
        answer.put("honux", 0);

        assertThat(result).isEqualTo(answer);
    }
}
