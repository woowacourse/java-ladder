package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    Ladder ladder;
    List<Record> log = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Line line1 = new Line(Arrays.asList(new Point(false, 0, true)
                                            , new Point(true,1,false)
                                            , new Point(false, 2, false)));
        Line line2 = new Line(Arrays.asList(new Point(false, 0, false)
                                            , new Point(false,1,true)
                                            , new Point(true, 2, false)));

        ladder = new Ladder(new ArrayList<>(Arrays.asList(line1, line2)));
        log.add(new Record(new ArrayList<>(Arrays.asList(0, 1, 2))));
    }

    @Test
    void 로그_결과_테스트() {
        Record record1 = new Record(Arrays.asList(0, 1, 2));
        Record record2 = new Record(Arrays.asList(1, 0, 2));
        Record record3 = new Record(Arrays.asList(1, 2, 0));
        List<Record> log1 = new ArrayList<>(Arrays.asList(record1, record2, record3));

        assertThat(ladder.drawLadder(log)).isEqualTo(log1);
    }

}
