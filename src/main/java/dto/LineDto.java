package dto;

import java.util.List;

public class LineDto {

    private final List<Boolean> paths;

    public LineDto(List<Boolean> paths) {
        this.paths = paths;
    }

    public List<Boolean> getPaths() {
        return paths;
    }
}
