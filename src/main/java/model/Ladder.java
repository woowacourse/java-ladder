package model;

import java.util.ArrayList;
import java.util.List;
import model.dto.LayerSteps;

public class Ladder {
    private List<Layer> layers;

    public Ladder(int height, int numberOfParticipants) {
        validateHeight(height);
        List<Layer> layers = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            layers.add(new Layer(numberOfParticipants));
        }
        this.layers = layers;
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야한다");
        }
    }

    public List<LayerSteps> captureLayerSteps() {
        return layers.stream().map(LayerSteps::new).toList();
    }
}
