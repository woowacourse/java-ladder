package view;

import static model.Line.CONNECTED;

import java.util.List;
import java.util.Map;
import model.Ladder;
import model.LadderRow;
import model.Line;
import model.Name;
import model.Participants;
import model.Position;
import model.Result;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String PARTICIPANT_RESULT = "\n실행결과";
    private static final String NAME_FORMAT = "%5s ";
    private static final String PARTICIPANTS_RESULT_FORMAT = "%s : %s ";

    public void printRandomLadderResult(Participants participants, Ladder ladder, Map<Position, Result> results) {
        System.out.println(RESULT_MESSAGE);
        printParticipantsName(participants);
        printLadder(ladder);
        printResults(results);
    }

    private void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Name::getValue)
                .toList();
        participantsName.forEach(name -> System.out.print(NAME_FORMAT.formatted(name)));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            printRow(ladder.getRow(i));
            System.out.println();
        }
    }

    private void printRow(LadderRow ladderRow) {
        System.out.print(LadderComponent.EMPTY_LINE);
        for (Line isLine : ladderRow.getIsLines()) {
            System.out.print(LadderComponent.DIVISION);
            System.out.print(LadderComponent.match(isLine == CONNECTED).toString());
        }
        System.out.print(LadderComponent.DIVISION);
    }

    public void printResults(Map<Position, Result> results) {
        for (Position position : results.keySet()) {
            System.out.print(NAME_FORMAT.formatted(results.get(position).getValue()));
        }
        System.out.println();
    }

    public void printParticipantResult(Result result) {
        System.out.println(PARTICIPANT_RESULT);
        System.out.println(result.getValue());
    }

    public void printParticipantResult(Map<Name, Result> results) {
        System.out.println(PARTICIPANT_RESULT);
        for (Name name : results.keySet()) {
            System.out.println(PARTICIPANTS_RESULT_FORMAT.formatted(name.getValue(), results.get(name).getValue()));
        }
    }
}
