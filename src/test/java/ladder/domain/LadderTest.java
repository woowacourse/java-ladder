package ladder.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    Ladder ladder;
    String names;
    int depth;

    @BeforeEach
    void setUp() {
        names = "pobi,honux,crong,jk";
        depth = 5;
        ladder = new Ladder(names,depth);
    }

    @Test
    void 사다리_객체_이름들로_생성() {
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
        Ladder ladder = new Ladder(names, 1);
        assertThat(ladder).isEqualTo(new Ladder(names));
    }

    @Test
    void 사다리_객체_길이_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(names, 0);
        });
    }

    @Test
    void 사다리_객체_라인들_출력() {
        System.out.println(ladder.getResultLadderLines());
    }

    @Test
    void 플레이어_이름_출력하기() {
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
    }

    @AfterEach
    void tearDown() {
        ladder = null;
        names = null;
    }
}
