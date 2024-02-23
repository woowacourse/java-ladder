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
    private static final String NAME_FORMAT = "%5s";
    private static final String STEP_DELIMITER = "|";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    public static final String STEP_PREFIX = "    ";

    public void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public void printParticipants(final Participants participants) {
        final String participantsName = participants.getValues()
                .stream()
                .map(this::getFormattedName)
                .collect(Collectors.joining(" "));
        System.out.println(participantsName);
    }

    private String getFormattedName(final Participant participant) {
        final String name = participant.getName();
        return String.format(NAME_FORMAT, name);
    }

    public void printLadder(final Ladder ladder) {
        final List<LadderStep> ladderSteps = ladder.getLadderSteps();
        final String ladderShape = ladderSteps.stream()
                .map(this::getLadderStepShape)
                .collect(Collectors.joining("\n"));
        System.out.println(ladderShape);
    }

    private String getLadderStepShape(final LadderStep ladderStep) {
        final String ladderStepShape = ladderStep.getLadderPaths()
                .stream()
                .map(Path::getShape)
                .collect(Collectors.joining(STEP_DELIMITER, STEP_DELIMITER, STEP_DELIMITER));
        return STEP_PREFIX + ladderStepShape;
    }

    public void printException(final RuntimeException exception) {
        System.out.println(EXCEPTION_PREFIX + exception.getMessage());
    }
}
