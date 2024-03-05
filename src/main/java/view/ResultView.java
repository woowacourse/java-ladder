package view;

import java.util.List;
import java.util.stream.IntStream;
import model.ladder.Ladder;
import model.people.People;
import model.people.Person;
import model.prizes.Prize;
import model.prizes.RewardBoard;

public class ResultView {
    private static final int MAX_INTERVAL = 6;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String INTERVAL = "     ";

    public void printLadderResult(People people, Ladder ladder) {
        System.out.printf("%n실행결과%n");
        printNames(people);

        ladder.getLines()
                .stream()
                .map(line -> printLine(line.findHorizontalPosition(), people.getParticipantsSize()))
                .forEach(System.out::println);
    }


    private String printLine(List<Integer> indexes, int personCount) {
        int maxHorizontalLines = personCount - 1;
        StringBuilder line = new StringBuilder(INTERVAL + VERTICAL_LINE);
        IntStream.range(0, maxHorizontalLines)
                .forEach(index -> line
                        .append(drawHorizontalLine(indexes.contains(index)))
                        .append(VERTICAL_LINE));

        return line.toString();
    }

    private String drawHorizontalLine(boolean hasHorizontalLine) {
        if (hasHorizontalLine) {
            return HORIZONTAL_LINE;
        }
        return INTERVAL;
    }

    private void printNames(People people) {
        for (Person participant : people.getParticipants()) {
            String name = participant.getName();
            printNameInterval(name);
            System.out.print(name);
        }
        System.out.println();
    }

    public void printPrizes(List<String> prizeName) {
        for (String name : prizeName) {
            printNameInterval(name);
            System.out.print(name);
        }
        System.out.println();
    }

    private void printNameInterval(String name) {
        for (int i = 0; i < MAX_INTERVAL - name.length(); i++) {
            System.out.print(" ");
        }
    }

    public void printProceedResult(Prize prize) {
        System.out.printf("%n실행결과%n");
        System.out.println(prize.getPrizeName());
    }

    public void printAllProceedResult(RewardBoard rewardBoard, People people) {
        System.out.printf("%n실행결과%n");
        for (Person participant : people.getParticipants()) {
            String findName = participant.getName();
            String findPrizeName = rewardBoard.findPrizeByName(findName).getPrizeName();
            System.out.printf("%s : %s%n", findName, findPrizeName);
        }
    }

}
