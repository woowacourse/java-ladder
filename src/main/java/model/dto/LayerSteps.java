package model.dto;

import java.util.List;
import model.Layer;

public record LayerSteps(List<Boolean> steps) {
    public LayerSteps(Layer layer) {
        this(layer.getSteps());
    }
}
