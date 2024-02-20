package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Layer {
    private List<Boolean> steps;

    public Layer(int numberOfParticipants) {
        List<Boolean> setUp = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfParticipants - 1; i++) {
            setUp.add(random.nextBoolean());
        }
        this.steps = setUp;
    }

    public int getLayerSize() {
        return steps.size();
    }
}
