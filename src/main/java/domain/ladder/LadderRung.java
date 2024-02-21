package domain.ladder;

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

    static LadderRung create(boolean isConnected) {
        return CACHE.get(isConnected);
    }

    boolean isConnected() {
        return this.isConnected;
    }
}
