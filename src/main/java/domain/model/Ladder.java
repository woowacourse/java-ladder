package domain.model;

import domain.vo.Height;
import domain.vo.Width;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final Height height;
    private final Width width;
    private final List<Layer> layers = new ArrayList<>();

    public Ladder(final Height height, final Width width) {
        this.height = height;
        this.width = width;
    }

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }

    public Height getHeight() {
        return this.height;
    }

    public Width getLineCount() {
        return this.width;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

}
