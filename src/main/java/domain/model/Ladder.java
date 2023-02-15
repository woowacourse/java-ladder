package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int height;
    private final int lineCount;
    private List<Layer> layers;

    public Ladder(int height, int lineCount) {
        this.height = height;
        this.lineCount = lineCount;
        this.layers = new ArrayList<>(height);
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLineCount() {
        return this.lineCount;
    }
}
