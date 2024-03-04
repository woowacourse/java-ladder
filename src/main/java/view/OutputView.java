package view;

import static model.Line.CONNECTED;

import java.util.Map;
import java.util.stream.IntStream;
import model.Ladder;
import model.LadderRow;
import model.Participant;
import model.Participants;
import model.Result;
import model.Results;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String PARTICIPANT_RESULT = "\n실행결과";
    private static final String NAME_FORMAT = "%5s ";
    private static final String PARTICIPANTS_RESULT_FORMAT = "%s : %s ";

    public void printLadderResult(Participants participants, Ladder ladder, Results results) {
        System.out.println(RESULT_MESSAGE);
        printParticipantsName(participants);
        printLadder(ladder);
        printResults(results);
    }

    private void printParticipantsName(Participants participants) {
        participants.getParticipants().stream()
                .map(Participant::getName)
                .toList()
                .forEach(name -> System.out.print(NAME_FORMAT.formatted(name.value())));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        IntStream.range(0, ladder.getHeight())
                .forEach(index -> printRow(ladder.getRow(index)));
    }

    private void printRow(LadderRow ladderRow) {
        System.out.print(LadderComponent.EMPTY_LINE);
        ladderRow.getIsLines()
                .forEach(isLine -> {
                    System.out.print(LadderComponent.DIVISION);
                    System.out.print(LadderComponent.match(isLine == CONNECTED).toString());
                });
        System.out.print(LadderComponent.DIVISION + "\n");
    }

    public void printResults(Results results) {
        results.getResults()
                .forEach(result -> System.out.print(NAME_FORMAT.formatted(result.getValue())));
        System.out.println();
    }

    public void printParticipantResult(Result result) {
        System.out.println(PARTICIPANT_RESULT);
        System.out.println(result.getValue());
    }

    public void printParticipantResults(Map<Participant, Result> results) {
        System.out.println(PARTICIPANT_RESULT);
        results.keySet()
                .forEach(participant -> System.out.println(PARTICIPANTS_RESULT_FORMAT
                        .formatted(participant.getName().value(), results.get(participant).getValue())));
    }

}
