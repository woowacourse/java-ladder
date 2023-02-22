package ladder.domain.ladder;

import ladder.domain.rule.StoolGenerator;

import java.util.List;

public class TestStoolGenerator implements StoolGenerator {

    private final List<Stool> stools;

    public TestStoolGenerator(List<Stool> stools) {
        this.stools = stools;
    }

    @Override
    public Stool generate() {
        return stools.remove(0);
    }
}
