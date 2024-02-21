package ladder.dto;

import java.util.List;

public record LadderResult(List<String> names, List<LineResult> lines) {
}
