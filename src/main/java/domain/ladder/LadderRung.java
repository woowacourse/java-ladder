package domain.ladder;

import domain.BooleanGenerator;
import java.util.HashMap;
import java.util.Map;

class LadderRung {
    private static final Map<Boolean, LadderRung> CACHE = new HashMap<>();

    private final boolean isConnected;

    static {
        CACHE.put(true, new LadderRung(true));
        CACHE.put(false, new LadderRung(false));
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
