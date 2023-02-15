package laddergame.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void print(final String message) {
        System.out.println(message);
    }

    public void printParticipants(final List<String> participantNames) {
        int maxNameLength = getMaxNameLength(participantNames);
        String paddedParticipantNames = participantNames.stream()
                .map(name -> getPaddedName(name, maxNameLength))
                .collect(Collectors.joining(" "));
        System.out.println(paddedParticipantNames.trim());
    }

    private String getPaddedName(final String participantName, final int maxNameLength) {
        String paddingFormat = String.format("%%-%ds", maxNameLength);
        return String.format(paddingFormat, participantName);
    }

    private int getMaxNameLength(final List<String> participantNames) {
        return participantNames.stream()
                .max(Comparator.comparingInt(String::length))
                .map(String::length)
                .orElse(0);
    }


}
