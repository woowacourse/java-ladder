package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.type.Line;
import domain.vo.Height;
import domain.vo.Width;

public class LadderMaker {

    private final BooleanGenerator booleanGenerator;

    public LadderMaker(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder make(Height height, Width width) {
        Ladder ladder = new Ladder(height, width);
        for (int i = 0; i < height.get(); i++) {
            ladder.addLayer(makeLayer(width.get()));
        }
        return ladder;
    }

    private Layer makeLayer(int lineCount) {
        Layer layer = new Layer();
        for (int i = 0; i < lineCount; i++) {
            makeLine(layer);
        }
        return layer;
    }

    private void makeLine(Layer layer) {
        if (booleanGenerator.generate()) {
            layer.makeLine(Line.CONNECTED);
            return;
        }
        layer.makeLine(Line.UNCONNECTED);
    }

}
