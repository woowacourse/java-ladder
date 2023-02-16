package laddergame.view;

import laddergame.domain.rung.Rungs;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.message.LadderMessage.*;

public class OutputView {

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printParticipants(final List<String> participantNames) {
        String paddedParticipantNames = participantNames.stream()
                .map(this::getPaddedName)
                .collect(Collectors.joining());
        System.out.println(paddedParticipantNames.trim());
    }

    public void printLadder(final List<Rungs> ladder, final List<String> participantNames) {
        int firstNameLength = participantNames.get(0).length();
        StringBuilder sb = new StringBuilder();

        ladder.stream()
                .map(Rungs::getRungs)
                .forEach(rungs ->
                {
                    sb.append(LADDER_PADDING.getMessage().repeat(firstNameLength));
                    String result = rungs.stream()
                            .map(rung -> makeRungMessage(rung.isExistence()))
                            .collect(Collectors.joining(LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage(), LADDER_FRAME.getMessage()));
                    sb.append(result).append("\n");
                });

        System.out.println(sb);
    }

    private String getPaddedName(final String participantName) {
        return String.format("%6s", participantName);
    }

    private String makeRungMessage(final boolean isExistence) {
        if (isExistence) {
            return LADDER_RUNG.getMessage();
        }
        return LADDER_BLANK.getMessage();
    }
}
