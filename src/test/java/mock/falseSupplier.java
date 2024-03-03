package mock;

import java.util.function.BooleanSupplier;

public class falseSupplier implements BooleanSupplier {
    @Override
    public boolean getAsBoolean() {
        return false;
    }
}
