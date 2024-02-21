package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_PREFIX = "실행결과\n";
    private static final String NAME_FORMAT = "%6s";
    private static final String LADDER_STEP_FORMAT = "     |%s|";
    private static final String STEP_DELIMITER = "|";

    public void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public void printParticipants(Participants participants) {
        String participantsName = participants.getValues()
                .stream()
                .map(this::getFormattedName)
                .collect(Collectors.joining());
        System.out.println(participantsName);
    }

    private String getFormattedName(Participant participant) {
        String name = participant.getName();
        return String.format(NAME_FORMAT, name);
    }

    public void printLadder(final Ladder ladder) {
        List<LadderStep> ladderSteps = ladder.getLadderSteps();
        String ladderShape = ladderSteps.stream()
                .map(this::getLadderStepShape)
                .collect(Collectors.joining("\n"));
        System.out.println(ladderShape);
    }

    private String getLadderStepShape(final LadderStep ladderStep) {
        String ladderStepShape = ladderStep.getLadderPaths()
                .stream()
                .map(Path::getShape)
                .collect(Collectors.joining(STEP_DELIMITER));
        return String.format(LADDER_STEP_FORMAT, ladderStepShape);
    }
}
