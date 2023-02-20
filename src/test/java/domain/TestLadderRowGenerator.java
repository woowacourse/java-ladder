package domain;

import java.util.List;

import utils.LadderRowGenerator;

public class TestLadderRowGenerator implements LadderRowGenerator {
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
