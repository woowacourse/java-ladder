package model;

import java.util.ArrayList;
import java.util.List;

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
}
