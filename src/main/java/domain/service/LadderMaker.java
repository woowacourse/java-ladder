package domain.service;

import domain.model.Ladder;
import domain.model.Layer;

public class LadderMaker {
    private final BooleanGenerator booleanGenerator;

    public LadderMaker(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder make(int height, int lineCount) {
        Ladder ladder = new Ladder(height, lineCount);
        for (int i = 0; i < height; i++) {
            ladder.addLayer(makeLayer(lineCount));
        }
        return ladder;
    }

    private Layer makeLayer(int lineCount) {
        Layer layer = new Layer();
        for (int i = 0; i < lineCount; i++) {
            layer.makeLine(booleanGenerator.generate());
        }
        return layer;
    }
}
