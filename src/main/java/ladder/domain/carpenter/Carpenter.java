package ladder.domain.carpenter;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.dto.MadeLineDto;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Line;

public class Carpenter {

    private final List<Line> ladder;
    private final Energy energy;

    public Carpenter(Height height, int participantCount, Energy energy) {
        ladder = makeLadder(height.getValue(), participantCount);
        this.energy = energy;
    }

    private List<Line> makeLadder(int buildLineCount, int stepAvailableCount) {
        List<Line> ladder = new ArrayList<>();

        for (int count = 0; count < buildLineCount; count++) {
            ladder.add(new Line(stepAvailableCount));
        }
        return ladder;
    }

    public MadeLadderDto getResultLadders() {
        List<MadeLineDto> ladderStatus = ladder.stream()
                .map(Line::getSteps)
                .toList();

        return new MadeLadderDto(ladderStatus);
    }

    public void buildLadders(int participantCount) {
        ladder.forEach(line -> tryBuildLadder(participantCount - 1, line));
    }

    private void tryBuildLadder(int workableStepCount, Line line) {
        for (int stepIdx = 0; stepIdx < workableStepCount; stepIdx++) {
            checkCanBuildStepPosition(line, stepIdx);
        }
    }

    private void checkCanBuildStepPosition(Line line, int nowPosition) {
        if (!line.isStepDuplicatedWithBeforeStep(nowPosition)) {
            buildStep(line, nowPosition);
        }
    }

    private void buildStep(Line line, int position) {
        if (energy.isEnergetic()) {
            line.buildSteps(position);
        }
    }
}
