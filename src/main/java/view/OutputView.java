package view;

import java.util.List;
import model.Ladder;
import model.LadderRow;
import model.Name;
import model.Participants;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s ";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Name::toString)
                .toList();
        participantsName.forEach(name -> System.out.print(NAME_FORMAT.formatted(name)));
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
        for (boolean isLine : ladderRow.isLines()) {
            System.out.print(LadderComponent.DIVISION);
            System.out.print(LadderComponent.match(isLine).toString());
        }
        System.out.print(LadderComponent.DIVISION);
    }
}
