package ladder.domain;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderTest {
    Ladder ladder;
    String names;
    int depth;

    @BeforeEach
    void setUp() {
        names = " pobi, honux, crong, jk";
        depth = 5;
        ladder = new Ladder(names, depth);
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

    @Test
    void 사다리_객체_결과_입력() {
        Ladder ladder = new Ladder(names, "꽝,5000,꽝,3000", depth);
        assertThat(ladder).isEqualTo(new Ladder(names, "꽝,5000,꽝,3000", depth));
    }

    @Test
    void 사다리_객체_결과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(names, "꽝,500000,꽝,3000", depth);
        });
    }

    @Test
    void 사다리_객체_결과_개수_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ladder(names, "꽝,500000,꽝", depth);
        });
    }

    @Test
    void 사다리_실행결과_출력() {
        Ladder ladder = new Ladder(names, "꽝,50000,꽝,3000", depth);
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
        System.out.println(ladder.getResultLadderRewards());
    }

    @Test
    void 사다리_게임_실행해보기() {
        Ladder ladder = new Ladder(names, "1000, 2000, 3000, 패스", 5);
        ladder.playRadder();
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
        System.out.println(ladder.getResultLadderRewards());
        for (String name : Arrays.asList(names.replaceAll(" ", "").split(","))) {
            System.out.println(name + " : " + ladder.getPlayerPosition(name));
        }
    }

    @Test
    void 사다리_이름_넣으면_결과_출력() {
        Ladder ladder = new Ladder(names, "1000, 2000, 3000, 패스", 5);
        ladder.playRadder();
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
        System.out.println(ladder.getResultLadderRewards());
        System.out.println("pobi : " + ladder.getResultLadderRewards("pobi"));
        System.out.println(ladder.getResultLadderRewards("all"));
    }

    @Test
    void 사다리_결과_없는_이름_예외() {
        Ladder ladder = new Ladder(names, "1000, 2000, 3000, 패스", 5);
        ladder.playRadder();
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
        System.out.println(ladder.getResultLadderRewards());
        System.out.println("pobi : " + ladder.getResultLadderRewards("pobi"));
        System.out.println(ladder.getResultLadderRewards("pobii"));
        assertThat(ladder.getResultLadderRewards("pobii")).isEqualTo(null);
    }

    @Test
    void 사다리_결과_없는_이름_예외_널_확인() {
        Ladder ladder = new Ladder(names, "1000, 2000, 3000, 패스", 5);
        ladder.playRadder();
        System.out.println(ladder.getResultLadderNames());
        System.out.println(ladder.getResultLadderLines());
        System.out.println(ladder.getResultLadderRewards());
        System.out.println("pobi : " + ladder.getResultLadderRewards("pobi"));
        System.out.println(ladder.getResultLadderRewards("pobii"));
        assertTrue(StringUtils.isEmpty(ladder.getResultLadderRewards("pobii")));
    }

    @AfterEach
    void tearDown() {
        ladder = null;
        names = null;
    }
}
