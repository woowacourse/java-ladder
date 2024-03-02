package dto;

import java.util.List;
import model.ladder.Layer;
import model.ladder.Step;

public record LayerSteps(List<Step> steps) {
    public LayerSteps(Layer layer) {
        this(layer.getSteps());
    }
}
