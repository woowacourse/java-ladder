package laddergame.view;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Rung;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_FRAME = "|";
    private static final String LADDER_RUNG = "-----";
    private static final String LADDER_BLANK = "     ";
    private static final String LADDER_PADDING = " ";

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printLadderResultGuide() {
        print(System.lineSeparator() + "사다리 결과" + System.lineSeparator());
    }

    public void printParticipantNames(final List<String> participantNames) {
        String paddedParticipantNames = padAllValues(participantNames, "%6s");
        print(paddedParticipantNames.trim());
    }

    public void printLadder(final List<Line> lines, final List<String> participantNames) {
        String firstParticipantName = getFirstParticipant(participantNames);
        int firstNameLength = getNameLength(firstParticipantName);
        String ladderMessage = makeLadderMessage(lines, firstNameLength);
        print(ladderMessage);
    }

    public void printResultNames(final List<String> resultNames) {
        String paddedResultNames = padAllValues(resultNames, "%-6s");
        print(paddedResultNames.trim());
    }

    public void printResultGuide() {
        print(System.lineSeparator() + "실행결과");
    }

    public void printResult(final Map<String, String> requestByParticipants, final List<String> participants) {
        print(makeResultMessage(requestByParticipants, participants));
    }

    private String makeResultMessage(final Map<String, String> requestByParticipants, final List<String> participants) {
        if (requestByParticipants.size() == 1) {
            String participantName = participants.get(0);
            return requestByParticipants.get(participantName);
        }
        return participants.stream()
                .map(participantName -> String.format("%s : %s", participantName, requestByParticipants.get(participantName)))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String padAllValues(final List<String> values, final String paddingFormat) {
        return values.stream()
                .map(value -> pad(paddingFormat, value))
                .collect(Collectors.joining());
    }

    private String pad(final String paddingFormat, final String participantName) {
        return String.format(paddingFormat, participantName);
    }

    private String getFirstParticipant(final List<String> participantNames) {
        return participantNames.get(0);
    }

    private int getNameLength(final String name) {
        return name.length();
    }

    private String makeLadderMessage(final List<Line> lines, final int firstNameLength) {
        return lines.stream()
                .map(rungs -> makeRungsMessage(rungs.getRungs(), firstNameLength))
                .collect(Collectors.joining(System.lineSeparator()));
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
}
