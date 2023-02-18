package ladder.domain;

public class Prize {

    private final PrizeName name;

    public Prize(String name) {
        this.name = new PrizeName(name);
    }
}
