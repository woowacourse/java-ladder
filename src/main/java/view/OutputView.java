package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String START_OF_LINE = "    |";
    public static final String EXIST_POINT = "-----|";
    public static final String EMPTY_POINT = "     |";

    public void printLadderResult(Participants participants, Ladder ladder, Result prizes) {
        System.out.println("\n사다리 결과\n");
        printNames(participants);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printNames(Participants participants) {
        List<Player> players = participants.getPlayers();
        for (Player player : players) {
            System.out.printf("%5s ", player.getName().getName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printOneLine(line);
        }
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

    private void printPrizes(Result result) {
        List<Prize> prizes = result.getPrizes();
        for (Prize prize : prizes) {
            System.out.printf("%5s ", prize.getPrize());
        }
        System.out.println();
    }

    public void printAllResult(Map<Name, Prize> matchResult) {
        System.out.println("\n실행 결과");
        for (Map.Entry<Name, Prize> entry : matchResult.entrySet()) {
            String name = entry.getKey().getName();
            String prize = entry.getValue().getPrize();
            System.out.println(name + " : " + prize);
        }
    }

    public void printOneResult(Prize prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize.getPrize());
    }
}
