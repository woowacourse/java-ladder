package helper;

import strategy.PassGenerator;

public class StubPassGenerator implements PassGenerator {

    private final boolean pass;

    public StubPassGenerator(boolean pass) {
        this.pass = pass;
    }

    @Override
    public boolean generate() {
        return pass;
    }
}
