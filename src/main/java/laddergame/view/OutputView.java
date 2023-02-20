package laddergame.view;

import laddergame.domain.rung.Rung;
import laddergame.domain.rung.Rungs;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static laddergame.view.message.LadderMessage.*;
import static laddergame.view.message.Message.RESULT_GUIDE;

public class OutputView {

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printResultGuide() {
        print(RESULT_GUIDE.getMessage());
    }

    public void printParticipantNames(final List<String> participantNames) {
        String paddedParticipantNames = makePaddedParticipantNames(participantNames);
        print(paddedParticipantNames.trim());
    }

    public void printLadder(final List<Rungs> ladder, final List<String> participantNames) {
        int firstNameLength = getLengthOfFirstParticipantName(participantNames);
        String ladderMessage = makeLadderMessage(ladder, firstNameLength);
        print(ladderMessage);
    }

    private String makePaddedParticipantNames(final List<String> participantNames) {
        return participantNames.stream()
                .map(this::getPaddedName)
                .collect(Collectors.joining());
    }

    private String getPaddedName(final String participantName) {
        return String.format("%6s", participantName);
    }

    private int getLengthOfFirstParticipantName(final List<String> participantNames) {
        String firstParticipantName = participantNames.get(0);
        return firstParticipantName.length();
    }

    private String makeLadderMessage(final List<Rungs> ladder, final int firstNameLength) {
        return ladder.stream()
                .map(Rungs::getRungs)
                .map(rungs -> {
                    StringJoiner ladderMessage = new StringJoiner("", LADDER_PADDING.getMessage().repeat(firstNameLength), "\n");
                    ladderMessage.add(makeRungsMessage(rungs));
                    return ladderMessage.toString();
                }).collect(Collectors.joining());
    }

    private String makeRungsMessage(final List<Rung> rungs) {
        return rungs.stream()
                .map(rung -> makeRungMessage(rung.exists()))
                .collect(Collectors.joining(LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage()));
    }

    private String makeRungMessage(final boolean isExistence) {
        if (isExistence) {
            return LADDER_RUNG.getMessage();
        }
        return LADDER_BLANK.getMessage();
    }
}
