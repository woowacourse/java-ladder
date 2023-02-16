package domain.model;

import domain.vo.Height;
import domain.vo.LineCount;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final LineCount lineCount;
    private List<Layer> layers;

    public Ladder(final Height height, final LineCount lineCount) {
        this.height = height;
        this.lineCount = lineCount;
        this.layers = new ArrayList<>();
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public Height getHeight() {
        return this.height;
    }

    public LineCount getLineCount() {
        return this.lineCount;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

}
