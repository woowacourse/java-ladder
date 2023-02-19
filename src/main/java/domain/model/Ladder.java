package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Height height;
    private final Width width;
    private final List<Layer> layers;

    private Ladder(final Height height, final Width width, List<Layer> layers) {
        this.height = height;
        this.width = width;
        this.layers = layers;
    }

    public static Ladder makeLadder(Height height, Width width) {
        List<Layer> layers = IntStream.range(0, height.getValue())
            .mapToObj(index -> Layer.makeLayerByRandom(width.getValue())).collect(Collectors.toList());
        return new Ladder(height, width, layers);
    }

    public List<Layer> getLayers() {
        return new ArrayList<>(layers);
    }

    public Height getHeight() {
        return this.height;
    }

    public Width getWidth() {
        return width;
    }
}
