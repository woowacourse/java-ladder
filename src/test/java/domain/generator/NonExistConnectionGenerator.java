package domain.generator;

public class NonExistConnectionGenerator implements ConnectionGenerator {

    @Override
    public boolean generate() {
        return false;
    }
}
