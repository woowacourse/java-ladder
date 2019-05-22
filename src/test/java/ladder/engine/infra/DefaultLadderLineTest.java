package ladder.engine.infra;

import ladder.engine.LadderLine;
import org.junit.jupiter.api.Test;

public class DefaultLadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLineFactory.createLine(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLineFactory.createLine(5);
        System.out.println("ladder result : " + line.move(1));
    }
}
