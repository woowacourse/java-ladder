package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Layer> ladder;

    private Ladder(final Height height, final List<Layer> ladder) {
        this.height = height;
        this.ladder = ladder;
    }

    public static Ladder of(final Height height, final int playerCount, final LinkGenerator linkGenerator) {
        final List<Layer> ladder = createLadder(height, playerCount, linkGenerator);
        return new Ladder(height, ladder);
    }

    private static List<Layer> createLadder(final Height height, final int playerCount, final LinkGenerator linkGenerator) {
        final List<Layer> ladder = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(Layer.of(playerCount, linkGenerator));
        }

        return ladder;
    }

    public List<Layer> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}


