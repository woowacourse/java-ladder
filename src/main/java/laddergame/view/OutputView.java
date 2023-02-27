package laddergame.view;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Rung;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.ParticipantName;
import laddergame.domain.result.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FRAME = "|";
    private static final String LADDER_RUNG = "-".repeat(ParticipantName.MAX_LENGTH);
    private static final String LADDER_BLANK = " ".repeat(ParticipantName.MAX_LENGTH);
    private static final String LADDER_PADDING = " ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PADDING_FORMAT_FOR_PARTICIPANTS = String.format("%%%ds", ParticipantName.MAX_LENGTH);
    private static final String PADDING_FORMAT_FOR_RESULTS = String.format("%%-%ds", ParticipantName.MAX_LENGTH);
    private static final String NAME_DELIMITER = " ";
    private static final String RESULT_DELIMITER = " : ";
    private static final int MINIMUM = 1;

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printLadderResultGuide() {
        print(NEW_LINE + "사다리 결과" + NEW_LINE);
    }

    public void printParticipantNames(final List<Participant> participants) {
        final String paddedParticipantNames = participants.stream()
                .map(participant -> pad(PADDING_FORMAT_FOR_PARTICIPANTS, participant.getName()))
                .collect(Collectors.joining(NAME_DELIMITER)).trim();
        print(paddedParticipantNames);
    }

    public void printLadder(final List<Line> lines, final List<Participant> participants) {
        String firstParticipantName = getFirstParticipantName(participants);
        String ladderMessage = makeLadderMessage(lines, firstParticipantName);
        print(ladderMessage);
    }

    public void printResultNames(final List<Result> results) {
        final String paddedResultNames = results.stream()
                .map(result -> pad(PADDING_FORMAT_FOR_RESULTS, result.getResultName()))
                .collect(Collectors.joining(NAME_DELIMITER)).trim();
        print(paddedResultNames);
    }

    public void printResultGuide() {
        print(NEW_LINE + "실행결과");
    }

    public void printResult(final Map<Participant, Result> requestByParticipants, final List<Participant> participants) {
        print(makeResultMessage(requestByParticipants, participants));
    }

    private String pad(final String paddingFormat, final String participantName) {
        return String.format(paddingFormat, participantName);
    }

    private String getFirstParticipantName(final List<Participant> participants) {
        final Participant firstParticipant = participants.get(0);
        return firstParticipant.getName();
    }

    private String makeLadderMessage(final List<Line> lines, final String firstNameLength) {
        return lines.stream()
                .map(rungs -> makeRungsMessage(rungs.getRungs(), firstNameLength.length()))
                .collect(Collectors.joining(NEW_LINE));
    }

    private String makeRungsMessage(final List<Rung> rungs, final int firstNameLength) {
        final String firstLadderFrame = LADDER_PADDING.repeat(firstNameLength) + LADDER_FRAME;
        return rungs.stream()
                .map(rung -> makeRungMessage(rung.exists()))
                .collect(Collectors.joining(LADDER_FRAME, firstLadderFrame, LADDER_FRAME));
    }

    private String makeRungMessage(final boolean isExistence) {
        if (isExistence) {
            return LADDER_RUNG;
        }
        return LADDER_BLANK;
    }

    private String makeResultMessage(final Map<Participant, Result> requestByParticipants, final List<Participant> participants) {
        if (requestByParticipants.size() == MINIMUM) {
            return requestByParticipants.values().stream()
                    .map(Result::getResultName)
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
        }
        return participants.stream()
                .map(participant -> String.join(RESULT_DELIMITER, participant.getName(), getResultName(requestByParticipants, participant)))
                .collect(Collectors.joining(NEW_LINE));
    }

    private String getResultName(final Map<Participant, Result> requestByParticipants, final Participant participant) {
        final Result result = requestByParticipants.get(participant);
        return result.getResultName();
    }
}
