package dto;

import java.util.List;

public record Result(List<String> names, List<LineDto> lines) {
}
