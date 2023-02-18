package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(int width, Height height, BooleanGenerator booleanGenerator) {
        this.ladders = new ArrayList<>();
        generate(width, height, booleanGenerator);
    }

    private void generate(int width, Height height, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladders.add(new Ladder(width, booleanGenerator));
        }
    }

    public int getHeight() {
        return ladders.size();
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
