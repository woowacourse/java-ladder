package ladder.domain;

import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void create_가로_새로_생성() {
        new Ladder(4, 5);
    }

    @Test
    void create_생성_후_ladder_초기화_후_프린트() {
        Ladder ladder = new Ladder(4, 5);
        System.out.println(ladder.drawLadderShape());
    }

    @Test
    void create_생성_후_ladder_초기화() {
        Ladder ladder = new Ladder(4, 5);
        System.out.println(ladder.drawLadderShape());
        for (Integer integer : ladder.getResult()) {
            System.out.print(integer + ", ");

        }
    }
}