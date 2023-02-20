package laddergame.view;

import laddergame.domain.rung.Rung;
import laddergame.domain.rung.Rungs;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static laddergame.view.message.LadderMessage.*;

public class OutputView {

    private static final int PADDING_DEFAULT_COUNT = 1;
    private static final String PARTICIPANT_NAME_FORMAT = "%6s";
    private static final String LADDER_RESULT_NAME_FORMAT = "%-6s";

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printParticipantNames(final List<String> participantNames) {
        String paddedParticipantNames = makePaddedParticipantNames(participantNames);
        print(paddedParticipantNames.trim());
    }

    public void printLadder(final List<Rungs> ladder, final List<String> participantNames) {
        int firstNameLength = getFirstParticipantNameLength(participantNames);
        String ladderMessage = makeLadderMessage(ladder, firstNameLength);
        print(ladderMessage);
    }

    public void printLadderResultNames(final List<String> participantNames, final List<String> ladderResultNames) {
        String firstPaddedFormat = getFirstPaddedFormat(participantNames);
        StringBuilder ladderResultMessage = new StringBuilder(String.format(firstPaddedFormat, ladderResultNames.get(0)));
        for (int i = 1; i < ladderResultNames.size(); i++) {
            ladderResultMessage.append(String.format(LADDER_RESULT_NAME_FORMAT, ladderResultNames.get(i)));
        }
        print(ladderResultMessage.toString().trim());
    }

    private String makePaddedParticipantNames(final List<String> participantNames) {
        return participantNames.stream()
                .map(this::getPaddedName)
                .collect(joining());
    }

    private String getPaddedName(final String participantName) {
        return String.format(PARTICIPANT_NAME_FORMAT, participantName);
    }

    private int getFirstParticipantNameLength(final List<String> participantNames) {
        String firstParticipantName = participantNames.get(0);
        return firstParticipantName.length();
    }

    private String makeLadderMessage(final List<Rungs> ladder, final int firstNameLength) {
        return ladder.stream()
                .map(ladderRungs -> makeRungsMessage(ladderRungs.getRungs(), firstNameLength))
                .collect(joining(System.lineSeparator()));
    }

    private String makeRungsMessage(final List<Rung> rungs, final int firstNameLength) {
        String ladderPrefix = LADDER_PADDING.getMessage().repeat(firstNameLength) + LADDER_FRAME.getMessage();
        return rungs.stream()
                .map(rung -> makeRungMessage(rung.isExistence()))
                .collect(joining(LADDER_FRAME.getMessage(), ladderPrefix, LADDER_FRAME.getMessage()));
    }

    private String makeRungMessage(final boolean isExistence) {
        if (isExistence) {
            return LADDER_RUNG.getMessage();
        }
        return LADDER_BLANK.getMessage();
    }

    private String getFirstPaddedFormat(final List<String> participantNames) {
        int firstPaddedCount = getFirstParticipantNameLength(participantNames) + PADDING_DEFAULT_COUNT;
        return "%-" + firstPaddedCount + "s";
    }
}
