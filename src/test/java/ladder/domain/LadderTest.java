package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    int countPerson;
    int ladderHeight;
    List<Line> lines;
    @BeforeEach
    public void setup(){
        countPerson = 3;
        ladderHeight = 5;
        lines = new Ladder(ladderHeight, countPerson).getLines();
    }
    @Test
    public void 사다리생성확인(){
        assertThat(lines.size()).isEqualTo(ladderHeight);
    }

    @Test
    public void 라인너비주입확인(){
        for (int  i = 0; i<lines.size(); i++) {
            assertThat(lines.get(i).getLength()).isEqualTo(countPerson);
        }
    }

}
