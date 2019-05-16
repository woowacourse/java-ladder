package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderWidthTest {

    @Test
    void 사다리_1줄_잘만들어졌는지_테스트() {
        List<Boolean> crossbars = new ArrayList<>();
        crossbars.add(true);
        crossbars.add(false);
        crossbars.add(true);
        assertThat(new LadderWidth(crossbars).toString()).isEqualTo("|-----|     |-----|");
    }
}
