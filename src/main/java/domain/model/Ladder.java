package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import domain.wrapper.Position;

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

    public boolean hasLeftAt(final Position position) {
        Layer layer = layers.get(position.getY());
        if (position.getX() == 0) {
            return false;
        }
        return layer.getLine(position.getX() - 1);
    }

    public boolean hasRightAt(final Position position) {
        Layer layer = layers.get(position.getY());
        if (position.getX() >= layer.getLines().size()) {
            return false;
        }
        return layer.getLine(position.getX());
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }

    public int getHeight() {
        return this.height.getValue();
    }

    public int getWidth() {
        return this.width.getValue();
    }

}
