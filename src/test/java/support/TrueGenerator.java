package support;

import domain.BooleanGenerator;
import domain.Connection;

public class TrueGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return Connection.IS_CONNECTED.getValue();
    }
}
