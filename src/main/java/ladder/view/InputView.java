package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static LadderGamePlayers createLadderGamePlayers() {
        System.out.println(MessageConstant.INPUT_LADDER_PLAYER_NAME);
        return createLadderGamePlayers(SCANNER.nextLine().split(DELIMITER));
    }

    public static LadderGamePlayers createLadderGamePlayers(String[] inputs) {
        try {
            List<LadderPlayer> players = Arrays.stream(inputs)
                    .map(String::trim)
                    .map(LadderPlayer::new)
                    .collect(toList());
            return new LadderGamePlayers(players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderGamePlayers();
        }
    }

    public static LadderGameGoals createLadderGameGoals(int numOfLadderPlayers) {
        System.out.println(NEW_LINE + MessageConstant.INPUT_LADDER_GOAL_NAME);
        return createLadderGameGoals(SCANNER.nextLine().split(DELIMITER), numOfLadderPlayers);
    }

    public static LadderGameGoals createLadderGameGoals(String[] inputs, int numOfLadderPlayers) {
        try {
            List<LadderGoal> goals = Arrays.stream(inputs)
                    .map(String::trim)
                    .map(LadderGoal::new)
                    .collect(toList());
            return new LadderGameGoals(goals, numOfLadderPlayers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderGameGoals(numOfLadderPlayers);
        }
    }

    public static LadderHeight createLadderHeight() {
        System.out.println(NEW_LINE + MessageConstant.INPUT_LADDER_HEIGHT);
        return createLadderHeight(SCANNER.nextLine());
    }

    public static LadderHeight createLadderHeight(String input) {
        try {
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderHeight();
        }
    }

    public static String getPlayerNameForFindingResult() {
        System.out.println(NEW_LINE + MessageConstant.INPUT_TARGET_NAME);
        return SCANNER.nextLine();
    }
}
