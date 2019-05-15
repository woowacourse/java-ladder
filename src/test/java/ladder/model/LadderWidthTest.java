package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderWidthTest {

    @Test
    void 사다리_1줄_잘만들어졌는지_테스트() {
        List<LadderCrossbar> crossbars = new ArrayList<>();
        crossbars.add(new LadderCrossbar(true));
        crossbars.add(new LadderCrossbar(false));
        crossbars.add(new LadderCrossbar(true));
        assertThat(new LadderWidth(crossbars).toString()).isEqualTo("|-----|     |-----|");
    }
}
