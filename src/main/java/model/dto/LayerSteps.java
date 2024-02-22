package model.dto;

import java.util.List;
import model.Layer;
import model.Step;

public record LayerSteps(List<Step> steps) {
    public LayerSteps(Layer layer) {
        this(layer.getSteps());
    }
}
