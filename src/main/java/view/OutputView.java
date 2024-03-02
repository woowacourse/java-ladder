package view;

import model.ladder.Ladder;
import model.ladder.LadderGame;
import model.ladder.LadderRow;
import model.ladder.Space;
import model.participant.Participant;
import model.participant.Participants;
import model.result.ParticipantsResult;
import model.result.Result;
import model.result.Results;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String SUFFIX_OF_EXCEPTION_MESSAGE = System.lineSeparator() + "다시 입력해주세요.";
    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_FORMAT = "%5s ";
    private static final String DELIMITER = " : ";

    public void printLadder(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printParticipantsName(ladderGame.getParticipants());
        printLadderDetail(ladderGame.getLadder());
        printResults(ladderGame.getResults());
    }

    private void printParticipantsName(List<Participant> participants) {
        for (Participant participant : participants){
            System.out.printf(NAME_FORMAT, participant.getName());
        }
        System.out.println();
    }

    private void printLadderDetail(Ladder ladder) {
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

    private void printResults(List<Result> results) {
        for (Result result : results){
            System.out.printf(NAME_FORMAT, result.name());
        }
        System.out.println();
    }

    public void printParticipantResult(Result result) {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
        System.out.println(result.name());
    }

    public void printLadderGameResult(ParticipantsResult participantsResult) {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
        for (Map.Entry<Participant, Result> reward : participantsResult.getParticipantsResult().entrySet()) {
            System.out.println(reward.getKey().getName() + DELIMITER + reward.getValue().name());
        }
    }

    public void printException(String message) {
        System.out.println(message + SUFFIX_OF_EXCEPTION_MESSAGE);
    }
}
