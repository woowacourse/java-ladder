package ladder.view;

import ladder.constant.MessageConstant;
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

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<LadderPlayer> makeLadderPlayers() {
        System.out.println(MessageConstant.INPUT_PLAYER_NAME);
        return makeLadderPlayers(scanner.nextLine().split(DELIMITER));
    }

    public static List<LadderPlayer> makeLadderPlayers(String[] inputs) {
        InputPlayerValidator.checkPlayerInputAccuracy(inputs);
        return Arrays.stream(inputs).map(String::trim).map(LadderPlayer::new).collect(Collectors.toList());
    }

    public static int makeLadderHeight() {
        System.out.println(MessageConstant.INPUT_LADDER_HEIGHT);
        return makeLadderHeight(scanner.nextLine());
    }

    public static int makeLadderHeight(String input) {
        InputLadderHeightValidator.checkLadderHeightInputAccuracy(input);
        return Integer.parseInt(input.trim());
    }

    public static List<LadderGoal> makeLadderGoals(int numOfPlayers) {
        System.out.println(MessageConstant.INPUT_LADDER_GOAL_NAME);
        return makeLadderGoals(scanner.nextLine().split(DELIMITER), numOfPlayers);
    }

    public static List<LadderGoal> makeLadderGoals(String[] inputs, int numOfPlayers) {
        InputLadderGoalValidator.checkLadderGoalInputAccuracy(inputs, numOfPlayers);
        return Arrays.stream(inputs).map(String::trim).map(LadderGoal::new).collect(Collectors.toList());
    }
}
