package ladder.domain.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Step;

public record BuiltLadderDto(List<String> builtLadder) {

    public static BuiltLadderDto of(List<Step> steps) {
        List<String> builtLadder = new ArrayList<>();

        for (Step step : steps) {
            builtLadder.add(step.getStatusToSymbol());
        }

        return new BuiltLadderDto(builtLadder);
    }
}
