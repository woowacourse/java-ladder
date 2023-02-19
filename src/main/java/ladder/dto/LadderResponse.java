package ladder.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Step;

public class LadderResponse {
    private final List<String> lines;

    public LadderResponse(List<String> lines) {
        this.lines = lines;
    }

    public static LadderResponse ofLadder(Ladder ladder) {
        List<String> linesString = ladder.getLines().stream()
                .map(Line::getSteps)
                .map(LadderResponse::stepsToString)
                .collect(toList());
        return new LadderResponse(linesString);
    }

    private static String stepsToString(List<Step> steps) {
        return "|" + steps.stream()
                .map(LadderResponse::stepToString)
                .collect(joining("|")) + "|";
    }

    private static String stepToString(Step step) {
        if (step == Step.EXIST) {
            return "-----";
        }
        if (step == Step.EMPTY) {
            return "     ";
        }
        throw new UnsupportedOperationException("[ERROR] 처리할 수 없는 Step 입니다.");
    }

    public List<String> getLines() {
        return lines;
    }
}
