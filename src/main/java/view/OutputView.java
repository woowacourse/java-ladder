package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.StepPoint;
import domain.participants.Name;
import domain.participants.Participants;
import domain.result.Prize;
import domain.result.Prizes;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String START_OF_LINE = "    |";
    public static final String EXIST_POINT = "-----|";
    public static final String EMPTY_POINT = "     |";

    public void printLadderInformation(Participants participants, Ladder ladder, Prizes prizes) {
        System.out.println("\n사다리 결과\n");
        printNames(participants);
        printLadder(ladder);
        printPrizes(prizes);
    }

    public void printAllResult(Map<String, String> allResult) {
        System.out.println("\n실행 결과");
        allResult.forEach((name, prize) -> System.out.println(name + " : " + prize));
    }

    public void printOneResult(String prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize);
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
        List<Prize> prizeValues = prizes.getPrizes();
        for (Prize prize : prizeValues) {
            System.out.printf("%5s ", prize.toString());
        }
        System.out.println();
    }

    private void printOneLine(Line line) {
        List<StepPoint> stepPoints = line.getStepPointCount();
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
