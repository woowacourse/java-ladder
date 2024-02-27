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

    public int move(List<Step> steps, int startIndex) {
        int lastIndex = startIndex;
        if (startIndex != steps.size() && steps.get(startIndex) == Step.EXIST) {
            lastIndex += 1;
            return lastIndex;
        }
        if (steps.get(startIndex - 1) == Step.EXIST) {
            lastIndex -= 1;
        }
        return lastIndex;
    }

    public void forEachLayer(Consumer<Layer> consumer) {
        layers.forEach(consumer);
    }
}
