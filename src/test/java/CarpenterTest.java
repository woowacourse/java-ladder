import domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarpenterTest {

    @Test
    void manyPoint4() {
        NumberGenerator oneGenerator = new OneGenerator();
        int playerCount = 3;
        WoodWorkMachine woodWorkMachine = new WoodWorkMachine(oneGenerator, playerCount);
        Line line = woodWorkMachine.makeLine();
        Carpenter carpenter = new Carpenter(4, playerCount, oneGenerator);
        assertThat(carpenter.makeLadder()).isEqualTo(new Ladder(List.of(line, line, line, line)));
    }
}
