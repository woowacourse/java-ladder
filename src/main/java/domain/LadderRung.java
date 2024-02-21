package domain;

class LadderRung {
    private final boolean isConnected;

    private LadderRung(final boolean isConnected) {
        this.isConnected = isConnected;
    }

    static LadderRung create(boolean isConnected) {
        return new LadderRung(isConnected);
    }

    boolean isConnected() {
        return this.isConnected;
    }
}
