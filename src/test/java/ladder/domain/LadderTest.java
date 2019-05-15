package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 라인_객체_이름들로_생성() {
        String names = "a,b,c";
        Ladder line = new Ladder(names);
        assertThat(line).isEqualTo(new Ladder(names));
    }

    @Test
    void 라인_객체_이름들로_생성_빈칸() {
        String names = "a, b, c";
        Ladder line = new Ladder(names);
        assertThat(line).isEqualTo(new Ladder(names));
    }

    @Test
    void 라인_객체_빈값일_경우() {
        String names = ",,";
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(names);
        });
    }
}
