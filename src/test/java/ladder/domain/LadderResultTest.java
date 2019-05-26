package ladder.domain;

import org.junit.jupiter.api.Test;

/**
 * @author heebg
 * @version 1.0 2019-05-16
 */
public class LadderResultTest {
    @Test
    void creat_객체_생성() {
        new LadderResult("pobi, crong, name", "꽝, 1000, 2000", 5);
    }

    @Test
    void getResultOfName_테스트() {
        LadderResult ladderResult = new LadderResult("pobi, crong, name", "꽝, 1000, 2000", 5);
        System.out.println(ladderResult.getResultOfName("pobi"));
    }

    @Test
    void getResultOfNameAll_테스트() {
        LadderResult ladderResult = new LadderResult("pobi, crong, name", "꽝, 1000, 2000", 5);
        System.out.println(ladderResult.getResultOfName("all"));
    }
}
