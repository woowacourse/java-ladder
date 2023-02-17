package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final Width width;
    private final List<Layer> layers;

    public Ladder(final Height height, final Width width) {
        this.height = height;
        this.width = width;
        this.layers = new ArrayList<>();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public Height getHeight() {
        return this.height;
    }

    public Width getLineCount() {
        return this.width;
    }

}
