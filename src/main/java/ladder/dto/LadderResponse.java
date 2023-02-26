package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Step;

public class LadderResponse {
    private final List<List<Step>> lines;

    public LadderResponse(List<List<Step>> lines) {
        this.lines = lines;
    }

    public static LadderResponse ofLadder(Ladder ladder) {
        return ladder.getLines().stream()
                .map(Line::getSteps)
                .collect(collectingAndThen(toList(), LadderResponse::new));
    }

    public List<List<Step>> getLines() {
        return lines;
    }
}
