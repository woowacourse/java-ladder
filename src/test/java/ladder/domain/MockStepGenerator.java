package ladder.domain;

public class MockStepGenerator implements StepGenerator {

    private final Step expected;

    public MockStepGenerator(Step expected) {
        this.expected = expected;
    }

    @Override
    public Step generate() {
        return expected;
    }
}
