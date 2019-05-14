package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderLineTest {
    @Test
    void 라인_객체_이름들로_생성() {
        String names = "a,b,c";
        LadderLine line = new LadderLine(names);
        assertThat(line).isEqualTo(new LadderLine(names));
    }

    @Test
    void 라인_객체_이름들로_생성_빈칸() {
        String names = "a, b, c";
        LadderLine line = new LadderLine(names);
        assertThat(line).isEqualTo(new LadderLine(names));
    }

    @Test
    void 라인_객체_빈값일_경우() {
        String names = ",,";
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderLine(names);
        });
    }
}
