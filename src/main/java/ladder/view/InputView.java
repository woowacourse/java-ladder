package ladder.view;

import ladder.constant.MessageConstant;
import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;
import ladder.validator.LadderGoalValidator;
import ladder.validator.LadderHeightValidator;
import ladder.validator.LadderPlayerValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<LadderPlayer> createLadderPlayers() {
        System.out.println(MessageConstant.INPUT_LADDER_PLAYER_NAME);
        return createLadderPlayers(SCANNER.nextLine().split(DELIMITER));
    }

    public static List<LadderPlayer> createLadderPlayers(String[] inputs) {
        try {
            LadderPlayerValidator.checkAccuracyOfUserInputs(inputs);
            return Arrays.stream(inputs).map(String::trim).map(LadderPlayer::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderPlayers();
        }
    }

    public static int createLadderHeight() {
        System.out.println(NEW_LINE + MessageConstant.INPUT_LADDER_HEIGHT);
        return createLadderHeight(SCANNER.nextLine());
    }

    public static int createLadderHeight(String input) {
        try {
            LadderHeightValidator.checkAccuracyOfUserInput(input);
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderHeight();
        }
    }

    public static List<LadderGoal> createLadderGoals(int numOfPlayers) {
        System.out.println(NEW_LINE + MessageConstant.INPUT_LADDER_GOAL_NAME);
        return createLadderGoals(SCANNER.nextLine().split(DELIMITER), numOfPlayers);
    }

    public static List<LadderGoal> createLadderGoals(String[] inputs, int numOfPlayers) {
        try {
            LadderGoalValidator.checkAccuracyOfUserInputs(inputs, numOfPlayers);
            return Arrays.stream(inputs).map(String::trim).map(LadderGoal::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadderGoals(numOfPlayers);
        }
    }

    public static String getPlayerNameForFindingResult() {
        System.out.println(NEW_LINE + MessageConstant.INPUT_TARGET_NAME);
        return SCANNER.nextLine();
    }
}
