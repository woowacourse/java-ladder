package view;

import model.Ladder;
import model.LadderRow;
import model.Participant;
import model.Participants;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s ";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
        participantsName.forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            printRow(ladder.getRow(i));
            System.out.println();
        }
    }

    private void printRow(LadderRow ladderRow) {
        System.out.print(LadderComponent.EMPTY_LINE);
        for (boolean isLine : ladderRow.getLineStatus()) {
            System.out.print(LadderComponent.DIVISION.getOutput());
            System.out.print(LadderComponent.match(isLine).getOutput());
        }
        System.out.print(LadderComponent.DIVISION.getOutput());
    }
}
