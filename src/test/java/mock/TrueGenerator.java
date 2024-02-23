package mock;

import domain.StepGenerator;

public class TrueGenerator implements StepGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
