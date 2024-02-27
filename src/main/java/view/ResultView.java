package view;

import domain.Names;
import domain.Player;
import domain.Players;
import domain.Results;
import domain.line.Line;
import domain.lines.Lines;

import java.util.Scanner;

public class ResultView {
    private static final String ALL_RESULT_COMMAND = "all";
    private static final Scanner scanner = new Scanner(System.in);

    private ResultView() {
    }

    public static void printLadder(Names names, Lines lines, Results results) {
        printResultNotice();
        printNames(names);
        printLines(names, lines);
        printResults(results);
    }

    private static void printResultNotice() {
        System.out.println();
        System.out.println("실행결과\n");
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

    public static void printGameResult(Results results, Players players) {
        String input = "";

        while (!input.equals(ALL_RESULT_COMMAND)) {
            input = inputSearchKey();

            System.out.println();
            System.out.println("실행 결과");

            StringBuilder searchResult = searchResult(results, players, input);
            System.out.println(searchResult);
        }
    }

    private static StringBuilder searchResult(Results results, Players players, String input) {
        StringBuilder resultLine = new StringBuilder();

        if (input.equals("all")) {
            return allResultBuilder(results, players, resultLine);
        }

        return singleResultBuilder(results, players, input, resultLine);
    }

    private static StringBuilder singleResultBuilder(Results results, Players players, String input, StringBuilder resultLine) {
        Player player = players.findByName(input);
        int position = player.getPosition();
        resultLine.append(results.findByPosition(position));
        return resultLine;
    }

    private static StringBuilder allResultBuilder(Results results, Players players, StringBuilder resultLine) {
        for (Player player : players.getPlayers()) {
            int currPosition = player.getPosition();
            resultLine.append(player.getName() + " : " + results.findByPosition(currPosition) + "\n");
        }
        return resultLine;
    }

    private static String inputSearchKey() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
