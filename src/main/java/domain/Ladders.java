package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Ladder> getLadders() {
        return new ArrayList<>(ladders);
    }
}
