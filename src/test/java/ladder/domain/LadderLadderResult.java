package ladder.domain;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderLadderResult {


    @Test
    public void 결과_받기() {

        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        assertEquals(Arrays.asList("꽝", "5000", "꽝", "3000"), ladderResult.reward());
    }

    @Test
    public void 결과_확인() {

        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        assertEquals("꽝", ladderResult.run(ladder, 0));
    }

    @Test
    public void 결과_확인2() {

        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        assertEquals("꽝", ladderResult.run(ladder, 1));
    }

    @Test
    public void 결과_확인3() {

        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        assertEquals("3000", ladderResult.run(ladder, 2));
    }

    @Test
    public void 결과_확인4() {

        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        assertEquals("5000", ladderResult.run(ladder, 3));
    }

    @Test
    public void 전체_결과_확인() {
        LadderResult ladderResult = new LadderResult("꽝,5000,꽝,3000");
        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        assertEquals(Arrays.asList("꽝", "꽝", "3000", "5000"), ladderResult.run(ladder));
    }


    @Test
    public void 플레이어_이용_테스트() {
        LadderReward ladderReward = new LadderReward("꽝,5000,꽝,3000");
        Players players = new Players("a,b,c,d");

        Ladder ladder = new Ladder(4, 2);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder.row(randomGenerator);

        LadderResult ladderResult = new LadderResult(ladderReward);
        PlayerResult playerResult = ladderResult.run(ladder, players.player("a"));

        PlayerResult expectPlayer = new PlayerResult("a", "꽝");
        assertEquals(expectPlayer, playerResult);
    }
}
