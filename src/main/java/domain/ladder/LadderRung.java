package domain.ladder;

import domain.BooleanGenerator;
import domain.Connection;
import java.util.HashMap;
import java.util.Map;

class LadderRung {
    private static final Map<Boolean, LadderRung> CACHE = new HashMap<>();

    private final boolean isConnected;

    static {
        CACHE.put(Connection.IS_CONNECTED.getValue(), new LadderRung(Connection.IS_CONNECTED.getValue()));
        CACHE.put(Connection.IS_NOT_CONNECTED.getValue(), new LadderRung(Connection.IS_NOT_CONNECTED.getValue()));
    }

    private LadderRung(final boolean isConnected) {
        this.isConnected = isConnected;
    }

    static LadderRung create(BooleanGenerator booleanGenerator) {
        return CACHE.get(booleanGenerator.generate());
    }

    boolean isConnected() {
        return this.isConnected;
    }
}
