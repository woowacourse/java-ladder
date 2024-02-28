package view;

import model.ladder.*;
import model.participant.Participant;
import model.participant.Participants;
import model.result.Result;
import model.result.Results;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s ";

    public void printResult(LadderGame ladderGame) {
        System.out.println(RESULT_MESSAGE);
        printParticipantsName(ladderGame.getParticipants());
        printLadder(ladderGame.getLadder());
        printDetailResult(ladderGame.getResults());
    }

    private void printParticipantsName(Participants participants) {
        List<String> participantsName = participants.getParticipants().stream()
                .map(Participant::getName)
                .toList();
        participantsName.forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
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

    private void printDetailResult(Results results){
        List<String> result = results.getResults().stream()
                .map(Result::name)
                .toList();
        result.forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }
    public void printOneResult(Result result){
        System.out.println("실행 결과");
        System.out.println(result.name());
    }

    public void printAllResult(Map<Participant, Result> results){
        System.out.println("실행 결과");
        for (Map.Entry<Participant, Result> result :results.entrySet()) {
            System.out.println(result.getKey().getName() + " : " + result.getValue().name());
        }
    }
}
