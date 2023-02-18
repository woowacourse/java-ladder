package laddergame.view;

import laddergame.domain.rung.Rung;
import laddergame.domain.rung.Rungs;

import java.util.List;
import java.util.StringJoiner;

import static java.util.stream.Collectors.joining;
import static laddergame.view.message.LadderMessage.*;

public class OutputView {

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

    private String makePaddedParticipantNames(final List<String> participantNames) {
        return participantNames.stream()
                .map(this::getPaddedName)
                .collect(joining());
    }

    private String getPaddedName(final String participantName) {
        return String.format("%6s", participantName);
    }

    private int getFirstParticipantNameLength(final List<String> participantNames) {
        String firstParticipantName = participantNames.get(0);
        return firstParticipantName.length();
    }

    private String makeLadderMessage(final List<Rungs> ladder, final int firstNameLength) {
        return ladder.stream()
                .map(ladderRungs -> {
                    List<Rung> rungs = ladderRungs.getRungs();
                    StringJoiner ladderMessage = new StringJoiner("", LADDER_PADDING.getMessage().repeat(firstNameLength), System.lineSeparator());
                    ladderMessage.add(makeRungsMessage(rungs));
                    return ladderMessage.toString();
                }).collect(joining());
    }

    private String makeRungsMessage(final List<Rung> rungs) {
        return rungs.stream()
                .map(rung -> makeRungMessage(rung.isExistence()))
                .collect(joining(LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage()));
    }

    private String makeRungMessage(final boolean isExistence) {
        if (isExistence) {
            return LADDER_RUNG.getMessage();
        }
        return LADDER_BLANK.getMessage();
    }
}
