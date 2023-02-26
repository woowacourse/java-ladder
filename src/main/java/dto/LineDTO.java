package dto;

import domain.Bridge;

import java.util.List;

public class LineDTO {
    private final List<Bridge> line;

    public LineDTO(final List<Bridge> line) {
        this.line = line;
    }

    public List<Bridge> getLineDTO() {
        return line;
    }
}
