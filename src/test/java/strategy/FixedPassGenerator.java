package strategy;

public class FixedPassGenerator implements PassGenerator {

    private final boolean pass;

    public FixedPassGenerator(boolean pass) {
        this.pass = pass;
    }

    @Override
    public boolean generate() {
        return pass;
    }
}
