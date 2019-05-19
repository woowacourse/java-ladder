package ladder.domain;

public class AlwaysTrue implements RandomValueGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
