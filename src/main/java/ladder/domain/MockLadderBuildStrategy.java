package ladder.domain;

public class MockLadderBuildStrategy implements LadderBuildingStrategy {
    @Override
    public boolean generate() {
        return true;
    }
}
