package view;

import domain.LadderGameResult;
import domain.Players;
import domain.Result;
import view.dto.LadderResultDto;

import java.util.List;

public class OutputView {

    private static final String LADDER_RESULT = "\n사다리 결과\n";
    private static final String EXECUTED_RESULT = "\n실행 결과";
    private static final String STICK = "|";
    private static final String LEG_UNIT = "-";
    private static final String FORMAT_NAME = "%6s";

    public static void printResult(LadderResultDto ladderResultDto) {
        System.out.println(LADDER_RESULT);
        List<String> playerNames = ladderResultDto.getPlayerNames();
        printPlayers(playerNames);

        for (List<Boolean> line : ladderResultDto.getLines()) {
            printPrefixSpace(playerNames);
            printLine(line);
        }

        printResults(ladderResultDto.getPlayerNames(), ladderResultDto.getResultNames());
        System.out.println();
    }


    private static void printPlayers(List<String> playerNames) {
        System.out.print(playerNames.get(0) + " ");
        playerNames.stream()
                .skip(1)
                .forEach(name -> System.out.printf(FORMAT_NAME, name));
        System.out.println();
    }

    private static void printPrefixSpace(List<String> players) {
        System.out.print(" ".repeat(getFirstPlayerNameSize(players)));
    }

    private static int getFirstPlayerNameSize(List<String> players) {
        return players.get(0).length();
    }

    private static void printLine(List<Boolean> legs) {
        for (Boolean leg : legs) {
            System.out.print(STICK);
            System.out.print(extractLeg(leg));
        }
        System.out.print(STICK + "\n");
    }

    private static void printResults(List<String> playerNames, List<String> results) {
        System.out.printf("%" + getFirstPlayerNameSize(playerNames) + "s", results.get(0));

        results.stream()
                .skip(1)
                .forEach(result -> System.out.printf(FORMAT_NAME, result));
    }

    private static String extractLeg(boolean isExistLeg) {
        if (isExistLeg) {
            return LEG_UNIT.repeat(5);
        }
        return " ".repeat(5);
    }

    public static void printOnePlayerResult(Result result) {
        System.out.println(EXECUTED_RESULT);
        System.out.println(result.getResult());
    }

    public static void printPlayersResult(Players players, LadderGameResult ladderGameResult) {
        System.out.println(EXECUTED_RESULT);
        players.getPlayers().stream()
                .forEach(player -> System.out.println(player.getName() + " : " + ladderGameResult.get(player).getResult()));
    }
}
