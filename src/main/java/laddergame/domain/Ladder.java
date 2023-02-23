package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Layer> ladder;

    public Ladder(final Height height, final int numberOfPlayers) {
        this.height = height;
        this.ladder = createLadder(numberOfPlayers);
    }

    public List<Layer> getLadder() {
        return Collections.unmodifiableList(ladder);
    }


    private List<Layer> createLadder(final int playerCount) {
        final List<Layer> ladder = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(Layer.from(playerCount));
        }

        return ladder;
    }
}
