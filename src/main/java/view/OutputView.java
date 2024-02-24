package view;

import model.*;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s ";

    public void printResult(Height height, Participants participants, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        printParticipantsName(participants);
        printLadder(height, ladder);

    }

    private void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
        participantsName.forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    private void printLadder(Height height, Ladder ladder) {
        for (int i = 0; i < height.getValue(); i++) {
            printRow(ladder.getRow(i));
            System.out.println();
        }
    }

    private void printRow(LadderRow ladderRow) {
        System.out.print(LadderComponent.EMPTY_LINE.getOutput());
        for (Space space : ladderRow.getSpaces()) {
            System.out.print(LadderComponent.DIVISION.getOutput());
            System.out.print(LadderComponent.match(space).getOutput());
        }
        System.out.print(LadderComponent.DIVISION.getOutput());
    }
}
