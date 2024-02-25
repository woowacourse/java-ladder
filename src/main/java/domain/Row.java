package domain;

public class Row {
    private final Bridges bridges;

    Row(Bridges bridges) {
        this.bridges = bridges;
    }

    public Bridges getBridges() {
        return bridges;
    }
}
