package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 사다리_객체_이름들로_생성() {
        String names = "a,b,c";
        Ladder line = new Ladder(names);
        assertThat(line).isEqualTo(new Ladder(names));
    }

    @Test
    void 사다리_객체_이름들로_생성_빈칸() {
        String names = "a, b, c";
        Ladder line = new Ladder(names);
        assertThat(line).isEqualTo(new Ladder(names));
    }

    @Test
    void 사다리_객체_빈값일_경우() {
        String names = ",,";
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(names);
        });
    }

    @Test
    void 사다리_객체_길이로_생성() {
        Ladder ladder = new Ladder("a,b,c", 1);
        assertThat(ladder).isEqualTo(new Ladder("a,b,c"));
    }

    @Test
    void 사다리_객체_길이_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder("a,b,c", 0);
        });
    }

    @Test
    void 사다리_객체_라인들_출력() {
        Ladder ladder = new Ladder("aaaa,bbbb,cccc,ddddd", 5);
        System.out.println(ladder.printLadderLines());
    }
}
