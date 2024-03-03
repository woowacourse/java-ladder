package mock;

import java.util.function.BooleanSupplier;

public class trueSupplier implements BooleanSupplier {
    @Override
    public boolean getAsBoolean() {
        return true;
    }
}
