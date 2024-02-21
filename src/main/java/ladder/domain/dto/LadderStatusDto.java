package ladder.domain.dto;

import java.util.List;
import ladder.domain.Step;

public record LadderStatusDto(List<Step> steps) {
}
