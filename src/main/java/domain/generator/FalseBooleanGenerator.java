package domain.generator;

public class FalseBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return false;
    }
}
