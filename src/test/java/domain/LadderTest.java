package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.LadderRowGenerator;

public class LadderTest {

    static class TestLadderRowGenerator implements LadderRowGenerator {

        private final List<List<Boolean>> ladder = List.of(
                List.of(true, false, true),
                List.of(false, true, false),
                List.of(true, false, false),
                List.of(false, true, false),
                List.of(true, false, true)
        );

        private int index = 0;

        @Override
        public LadderRow generate(int userCount) {
            return new LadderRow(ladder.get(index++));
        }
    }
}
