package view;

import domain.Names;
import domain.Player;
import domain.Players;
import domain.Results;
import domain.line.Line;
import domain.lines.Lines;

import java.util.Scanner;

public class ResultView {
    private final static Scanner scanner = new Scanner(System.in);

    private ResultView() {
    }

    public static void printLadder(Names names, Lines lines, Results results) {
        printResultNotice();
        printNames(names);
        printLines(names, lines);
        printResults(results);
    }

    private static void printNames(Names names) {
        String firstName = names.firstName() + " ";
        StringBuilder nameLine = new StringBuilder();

        for (int i = 1; i < names.size(); i++) {
            nameLine.append(String.format("%6s", names.nameOf(i)));
        }
        System.out.println(firstName + nameLine);
    }

    private static void printLines(Names names, Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(ResultMessage.ladderPadding(names));
            System.out.print(ResultMessage.of(line));
        }
    }

    private static void printResults(Results results) {
        StringBuilder resultLine = new StringBuilder();

        for (int i = 0; i < results.size(); i++) {
            resultLine.append(String.format("%-6s", results.getResults().get(i).getResult()));
        }
        System.out.println(resultLine);
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("실행결과\n");
    }

    public static void printGameResult(Results results, Players players) {
        while (true) {
            System.out.println();
            System.out.println("결과를 보고 싶은 사람은?");
            String input = scanner.nextLine();

            System.out.println();
            System.out.println("실행 결과");

            if (input.equals("all")) {
                for (Player player : players.getPlayers()) {
                    int currPosition = player.getPosition();
                    System.out.println(player.getName() + " : " + results.getResults().get(currPosition).getResult());
                }
                break;
            }

            Player player = players.findByName(input);
            int position = player.getPosition();
            System.out.println(results.getResults().get(position).getResult());
        }
    }
}
