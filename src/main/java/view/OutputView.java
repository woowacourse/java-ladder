package view;

import model.ladder.*;
import model.participant.Participant;
import model.participant.Participants;
import model.result.Result;
import model.result.Results;
import model.result.Rewards;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_FORMAT = "%5s ";
    private static final String DELIMITER = " : ";

    public void printLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printParticipantsName(ladderGame.getParticipants());
        printLadder(ladderGame.getLadder());
        printResults(ladderGame.getResults());
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

    private void printResults(Results results){
        List<String> result = results.getResults().stream()
                .map(Result::name)
                .toList();
        result.forEach(resultName -> System.out.printf(NAME_FORMAT, resultName));
        System.out.println();
    }
    public void printParticipantResult(Result result){
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
        System.out.println(result.name());
    }

    public void printAllParticipantsResult(Rewards rewards){
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
        for (Map.Entry<Participant, Result> reward :rewards.getRewards().entrySet()) {
            System.out.println(reward.getKey().getName() + DELIMITER + reward.getValue().name());
        }
    }
}
