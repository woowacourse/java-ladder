package view;

import static java.lang.System.lineSeparator;

import domain.Ladder;
import domain.Leg;
import domain.Line;
import domain.PlayerName;
import domain.PlayerNames;
import domain.Reward;
import domain.Rewards;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LADDER_RESULT = lineSeparator() + "사다리 결과" + lineSeparator();
    private static final String EXECUTION_RESULT = lineSeparator() + "실행 결과";
    private static final String STICK = "|";
    private static final String LEG_UNIT = "-";
    private static final String FORMAT_NAME = "%6s";
    private static final String FORMAT_REWARD = "%6s";
    private static final String FORMAT_ALL_PLAYER_RESULT = "%s : %s" + lineSeparator();

    public static void printLadderGame(PlayerNames playerNames, Ladder ladder, Rewards rewards) {
        System.out.println(LADDER_RESULT);
        printPlayers(playerNames.getPlayerNames());
        printLines(playerNames, ladder);
        printRewards(playerNames, rewards.getRewards());
    }

    private static void printPlayers(List<PlayerName> players) {
        System.out.print(players.get(0).getName() + " ");
        players.stream().skip(1).forEach((player) -> {
            System.out.printf(FORMAT_NAME, player.getName());
        });
        System.out.println();
    }

    private static void printLines(PlayerNames playerNames, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printPrefixSpace(playerNames.getPlayerNames());
            printLine(line.getLegs());
        }
    }

    private static void printPrefixSpace(List<PlayerName> players) {
        int firstPlayerNameLength = players.get(0).getName().length();
        System.out.print(" ".repeat(firstPlayerNameLength));
    }

    private static void printLine(List<Leg> legs) {
        for (Leg leg : legs) {
            System.out.print(STICK);
            System.out.print(extractLeg(leg.isConnected()));
        }
        System.out.print(STICK + lineSeparator());
    }

    private static String extractLeg(boolean isExistLeg) {
        if (isExistLeg) {
            return LEG_UNIT.repeat(5);
        }
        return " ".repeat(5);
    }

    private static void printRewards(PlayerNames playerNames, List<Reward> rewards) {
        System.out.print(rewards.get(0).getReward() + " ");
        rewards.stream().skip(1).forEach((reward) -> {
            System.out.printf(FORMAT_REWARD, reward.getReward());
        });
        System.out.println();
    }

    public static void printPlayerResult(String playerReward) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(playerReward);
    }

    public static void printAllPlayerResult(Map<PlayerName, String> allPlayerReward) {
        System.out.println(EXECUTION_RESULT);
        for (PlayerName playerName : allPlayerReward.keySet()) {
            System.out.printf(FORMAT_ALL_PLAYER_RESULT, playerName.getName(), allPlayerReward.get(playerName));
        }
    }
}
