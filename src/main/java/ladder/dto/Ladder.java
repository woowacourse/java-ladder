package ladder.dto;

import java.util.List;

public record Ladder(List<String> names, List<LineResult> lines, List<String> destinations) {
}
