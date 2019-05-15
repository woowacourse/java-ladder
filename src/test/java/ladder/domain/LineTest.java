package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 생성자확인() {
        Line line = new Line(Arrays.asList(false, true, false));
        assertThat(line).isEqualTo(new Line(Arrays.asList(false, true, false)));
    }

    @Test
    void 한사람_생성자_확인() {
        Line line = new Line(Arrays.asList(false));
        assertThat(line).isEqualTo(new Line(Arrays.asList(false)));
    }

    @Test
    void 라인_출력() {
        Line line = new Line(Arrays.asList(false, true, false, true));
        assertThat(line.makeLine()).isEqualTo("     |-----|     |-----|");

    }

}
