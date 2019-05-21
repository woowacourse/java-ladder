package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    Ladder ladder;
    List<Record> log = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Line line1 = new Line(new ArrayList<>(Arrays.asList(true, false)));
        Line line2 = new Line(new ArrayList<>(Arrays.asList(false, true)));
        ladder = new Ladder(new ArrayList<>(Arrays.asList(line1, line2)));
        log.add(new Record(new ArrayList<>(Arrays.asList(0, 1, 2))));
    }

    @Test
    void 로그_결과_테스트() {
        Record record1 = new Record(Arrays.asList(0, 1, 2));
        Record record2 = new Record(Arrays.asList(1, 0, 2));
        Record record3 = new Record(Arrays.asList(1, 2, 0));
        List<Record> log1 = new ArrayList<>(Arrays.asList(record1, record2, record3));

        assertThat(ladder.drawLadder()).isEqualTo(log1);
    }

    @Test
    void 출력_테스트() {
        assertThat(ladder.toString()).isEqualTo("|-----|     |\n" +
                                                "|     |-----|");
    }
}
