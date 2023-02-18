package ladder.domain;

public class MockGenerator implements Generator {

    private final boolean expected;

    public MockGenerator(boolean expected) {
        this.expected = expected;
    }

    @Override
    public boolean generate() {
        return expected;
    }
}
