package domain.model;

import domain.vo.Height;
import domain.vo.Width;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final Height height;
    private final Width width;
    private final List<Layer> layers;

    public Ladder(final Height height, final Width width, final List<Layer> layers) {
        this.height = height;
        this.width = width;
        this.layers = layers;
    }

    public void makeLineInLayers() {
        IntStream.range(0, height.getValue())
            .mapToObj(layers::get)
            .forEach(
                layer -> IntStream.range(0, width.getValue())
                    .forEach(j -> layer.makeLine()));
    }

    public List<Layer> getLayers() {
        return List.copyOf(layers);
    }
}
