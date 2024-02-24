package model;

import dto.LayerSteps;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Layer> layers;

    public Ladder(int height, int numberOfParticipants) {
        validateHeight(height);
        this.layers = generateLayers(height, numberOfParticipants);
    }

    private List<Layer> generateLayers(int height, int numberOfParticipants) {
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            layers.add(new Layer(numberOfParticipants));
        }
        return layers;
    }

    private void validateHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상이어야한다");
        }
    }

    public List<LayerSteps> captureLayerSteps() {
        return layers.stream().map(LayerSteps::new).toList();
    }
}
