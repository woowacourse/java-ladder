package ladder.dto;

import ladder.domain.StepStatus;

import java.util.List;

public record LineResult(List<StepStatus> value) {
}
