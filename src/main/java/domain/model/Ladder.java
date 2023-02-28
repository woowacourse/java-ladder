package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import domain.wrapper.Position;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int START_POSITION = 0;

    private final Height height;
    private final Width width;
    private final List<Layer> layers = new ArrayList<>();

    public Ladder(final int height, final int width) {
        this.height = new Height(height);
        this.width = new Width(width);
    }

    public boolean hasLeftAt(final Position position) {
        Layer layer = layers.get(position.getY());
        if (position.getX() == START_POSITION) {
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

    public void addLayer(final Layer layer) {
        layers.add(layer);
    }

    public List<Layer> getLayers() {
        return List.copyOf(layers);
    }

    public int getHeight() {
        return this.height.getValue();
    }

    public int getWidth() {
        return this.width.getValue();
    }

}
