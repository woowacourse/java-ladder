package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(int height, int numberOfParticipants) {
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            layers.add(new Layer(numberOfParticipants));
        }
        this.layers = layers;
    }

    public void forEachLayer(Consumer<Layer> consumer) {
        layers.forEach(consumer);
    }
}
