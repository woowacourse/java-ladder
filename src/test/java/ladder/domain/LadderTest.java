package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    int personNumber;
    int ladderHeight;
    List<Line> lines;
    @BeforeEach
    public void setup(){
        personNumber = 3;
        ladderHeight = 5;
        List<Line> lines = new Ladder(personNumber, ladderHeight).getLines();
    }
    @Test
    public void 사다리생성확인(){
        assertThat(lines.size()).isEqualTo(3);
    }

    @Test
    public void 라인높이주입확인(){
        for (int  i = 0; i<lines.size(); i++) {
            assertThat(lines.get(i).getHeight()).isEqualTo(5);
        }
    }


}
