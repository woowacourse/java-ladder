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

    public List<Layer> getLayers() {
        return this.layers;
    }

    public int getHeightInt() {
        return this.height.get();
    }

    public int getLineCountInt() {
        return this.width.get();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

}
