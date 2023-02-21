package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderMakerTest {

    @Test
    @DisplayName("주어진 사이즈대로 사다리가 생성된다.")
    void makeLadderTest() {
        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        BooleanGenerator booleanGenerator = new IntendedBooleanGenerator();

        LadderSize ladderSize = new LadderSize(3, 4);
        LadderMaker ladderMaker = new LadderMaker(ladderSize, booleanGenerator);

        Ladder ladder = ladderMaker.generate();
        List<Line> lines = ladder.getLines();
        List<ConnectionStatus> lineStatus = lines.get(0).getLineStatus();

        assertEquals(lines.size(), 4);
        assertEquals(lineStatus.size(), 3);
    }
}
