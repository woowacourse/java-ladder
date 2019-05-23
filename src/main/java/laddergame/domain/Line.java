package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> line;
    private final int width;

    public Line(List<Boolean> line) {
        this.line = line;
        this.width = line.size();
    }

    public boolean getHandle(int index) {
        return line.get(index);
    }

    public int getWidth() {
        return width;
    }

    public void swap(PlayerResult playerResult) {
        List<Player> players = playerResult.getPlayers();

        for (int i = 0; i < width; i++) {
            if (line.get(i)) {
                Collections.swap(players, i, i + 1);
            }
        }
    }
}
