package model;

import dto.LayerSteps;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(List<Layer> layers) {
        this.layers = layers;
    }

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

    public int climbDownEach(int startIndex) {
        int currentIndex = startIndex;
        for (Layer layer : layers) {
            currentIndex = layer.move(currentIndex);
        }
        return currentIndex;
    }

    public List<LayerSteps> captureLayerSteps() {
        return layers.stream().map(LayerSteps::new).toList();
    }
}
