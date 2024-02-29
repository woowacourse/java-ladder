package ladder.domain.dto;

import java.util.List;
import ladder.domain.ladder.Step;

public record StepStatusDto(List<Step> builtStep) {
}
