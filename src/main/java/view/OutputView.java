package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Name;
import domain.Participants;
import domain.Prizes;
import domain.StepPoint;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public static final String START_OF_LINE = "    |";
    public static final String EXIST_POINT = "-----|";
    public static final String EMPTY_POINT = "     |";

    public void printResult(Participants participants, Ladder ladder, Prizes prizes) {
        System.out.println("\n사다리 결과\n");
        printNames(participants);
        printLadder(ladder);
        printPrizes(prizes);
    }

    public void printAllResult(LadderResult ladderResult, Participants participants, Prizes prizes) {
        System.out.println("\n실행 결과");
        List<Name> names = participants.getParticipantsName();
        List<String> prizesValue = prizes.getPrizes();

        IntStream.range(0, participants.getParticipantsCount())
                .forEach(i -> System.out.printf("%s : %s\n", names.get(i).getName(),
                        prizesValue.get(ladderResult.getOneResult(i))));
    }

    public void printOneResult(LadderResult ladderResult, Prizes prizes, int firstPosition) {
        System.out.println("\n실행 결과");
        List<String> prizesValue = prizes.getPrizes();
        System.out.println(prizesValue.get(ladderResult.getOneResult(firstPosition)));
    }


    private void printNames(Participants participants) {
        List<Name> participantNames = participants.getParticipantsName();
        for (Name name : participantNames) {
            System.out.printf("%5s ", name.getName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printOneLine(line);
        }
    }

    private void printPrizes(Prizes prizes) {
        List<String> prizeValues = prizes.getPrizes();
        for (String prizeValue : prizeValues) {
            System.out.printf("%5s ", prizeValue);
        }
        System.out.println();
    }

    private void printOneLine(Line line) {
        List<StepPoint> stepPoints = line.getStepPoints();
        System.out.print(START_OF_LINE);
        for (StepPoint stepPoint : stepPoints) {
            printOnePoint(stepPoint);
        }
        System.out.println();
    }

    private void printOnePoint(StepPoint stepPoint) {
        if (stepPoint.isExist()) {
            System.out.print(EXIST_POINT);
            return;
        }
        System.out.print(EMPTY_POINT);
    }
}
