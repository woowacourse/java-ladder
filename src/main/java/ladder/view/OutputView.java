package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.result.GameResults;
import ladder.domain.result.LadderGamePrize;
import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_PREFIX = "사다리 결과\n";
    private static final String NAME_FORMAT = "%5s";
    private static final String STEP_DELIMITER = "|";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static final String STEP_PREFIX = "    ";
    private static final String PATH_EXIST = "-----";
    private static final String PATH_EMPTY = "     ";
    private static final String RESULT_PREFIX = "실행결과";
    private static final String RESULT_FORMAT = "%s : %s";

    public void printLadderPrefix() {
        System.out.println(LADDER_PREFIX);
    }

    public void printParticipants(final Participants participants) {
        final String participantsName = participants.getParticipantsName()
                .stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .collect(Collectors.joining(" "));
        System.out.println(participantsName);
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
                .map(this::determinePathShape)
                .collect(Collectors.joining(STEP_DELIMITER, STEP_DELIMITER, STEP_DELIMITER));
        return STEP_PREFIX + ladderStepShape;
    }

    private String determinePathShape(final Path path) {
        if (path.isExist()) {
            return PATH_EXIST;
        }
        return PATH_EMPTY;
    }

    public void printLadderGamePrize(final LadderGamePrize ladderGamePrize) {
        final String ladderResult = ladderGamePrize.getValues()
                .stream()
                .map(result -> String.format(NAME_FORMAT, result))
                .collect(Collectors.joining(" "));
        System.out.println(ladderResult);
    }

    public void printAllGameResults(final GameResults gameResults) {
        final Map<String, String> allGameResults = gameResults.getValues();
        final String formattedResults = allGameResults.entrySet()
                .stream()
                .map(entry -> String.format(RESULT_FORMAT, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
        printResultPrefix();
        System.out.println(formattedResults);
    }

    public void printPersonalGameResult(final String result) {
        printResultPrefix();
        System.out.println(result);
    }

    private void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public void printException(final RuntimeException exception) {
        System.out.println(EXCEPTION_PREFIX + exception.getMessage());
    }
}
