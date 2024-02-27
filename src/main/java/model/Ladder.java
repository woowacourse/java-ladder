package model;

import dto.LayerSteps;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Layer> layers;

    public Ladder(Height height, int numberOfParticipants) {
        this.layers = generateLayers(height, numberOfParticipants);
    }

    private List<Layer> generateLayers(Height height, int numberOfParticipants) {
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            layers.add(new Layer(StepExistenceGenerator.generate(numberOfParticipants)));
        }
        return layers;
    }

    public List<LayerSteps> captureLayerSteps() {
        return layers.stream().map(LayerSteps::new).toList();
    }
}
