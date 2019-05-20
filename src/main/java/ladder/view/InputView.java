package ladder.view;

import ladder.MessageCollection;
import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;
import ladder.validator.InputLadderGoalValidator;
import ladder.validator.InputLadderHeightValidator;
import ladder.validator.InputPlayerValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ENTER = "\n";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<LadderPlayer> makeLadderPlayers() {
        System.out.println(MessageCollection.INPUT_PLAYER_NAME);
        return makeLadderPlayers(scanner.nextLine().split(DELIMITER));
    }

    public static List<LadderPlayer> makeLadderPlayers(String[] inputs) {
        try {
            InputPlayerValidator.checkPlayerInputAccuracy(inputs);
            return Arrays.stream(inputs).map(String::trim).map(LadderPlayer::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderPlayers();
        }
    }

    public static int makeLadderHeight() {
        System.out.println(ENTER + MessageCollection.INPUT_LADDER_HEIGHT);
        return makeLadderHeight(scanner.nextLine());
    }

    public static int makeLadderHeight(String input) {
        try {
            InputLadderHeightValidator.checkLadderHeightInputAccuracy(input);
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderHeight();
        }

    }

    public static List<LadderGoal> makeLadderGoals(int numOfPlayers) {
        System.out.println(ENTER + MessageCollection.INPUT_LADDER_GOAL_NAME);
        return makeLadderGoals(scanner.nextLine().split(DELIMITER), numOfPlayers);
    }

    public static List<LadderGoal> makeLadderGoals(String[] inputs, int numOfPlayers) {
        try {
            InputLadderGoalValidator.checkLadderGoalInputAccuracy(inputs, numOfPlayers);
            return Arrays.stream(inputs).map(String::trim).map(LadderGoal::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderGoals(numOfPlayers);
        }

    }

    public static String findName() {
        System.out.println(ENTER + MessageCollection.INPUT_FIND_NAME);
        return scanner.nextLine();
    }
}
