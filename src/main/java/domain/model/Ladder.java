package domain.model;

import domain.vo.Height;
import domain.vo.Location;
import domain.vo.Width;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final String START_LOCATION_NOT_EXIST = "사다리에 존재하지 않는 시작 시점입니다.";
    private final Height height;
    private final Width width;
    private final List<Layer> layers;

    public Ladder(final Height height, final Width width, final List<Layer> layers) {
        this.height = height;
        this.width = width;
        this.layers = layers;
        makeLineInLayers();
    }

    private void makeLineInLayers() {
        IntStream.range(0, height.getValue())
            .mapToObj(layers::get)
            .forEach(
                layer -> IntStream.range(0, width.getValue())
                    .forEach(j -> layer.makeLine()));
    }

    public int ride(final Location location) {
        checkStartLocation(location);
        IntStream.range(0, height.getValue())
            .forEach(i -> layers.get(location.getVertical()).move(location));
        return location.getHorizon();
    }

    public List<Layer> getLayers() {
        return List.copyOf(layers);
    }

    private void checkStartLocation(final Location location) {
        if (location.getHorizon() > width.getValue() + 1) {
            throw new IllegalArgumentException(START_LOCATION_NOT_EXIST);
        }
    }
}
