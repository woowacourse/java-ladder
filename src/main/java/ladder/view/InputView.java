package ladder.view;

import ladder.MessageCollection;
import ladder.model.LadderGoal;
import ladder.model.LadderPlayer;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String ENTER = "\n";
    private static final String DELIMITER = ",";
    private static final int MIN_HEIGHT = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public List<LadderPlayer> makeLadderPlayers() {
        System.out.println(MessageCollection.INPUT_PLAYER_NAME);
        return makeLadderPlayers(scanner.nextLine().split(DELIMITER));
    }

    List<LadderPlayer> makeLadderPlayers(String[] inputs) {
        try {
            checkPlayerInputAccuracy(inputs);
            return Arrays.stream(inputs).map(String::trim).map(LadderPlayer::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderPlayers();
        }
    }

    private void checkPlayerInputAccuracy(String[] inputs) {
        if (isOnePlayer(inputs)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_ONE_PLAYER);
        }

        if (isOverlapPlayer(inputs)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_OVERLAP_PLAYERS);
        }
    }

    private boolean isOnePlayer(String[] inputs) {
        return inputs.length == 1;
    }

    private boolean isOverlapPlayer(String[] inputs) {
        Set<String> checkOverlapNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapNames.size() != inputs.length;
    }

    public int makeLadderHeight() {
        System.out.println(ENTER + MessageCollection.INPUT_LADDER_HEIGHT);
        return makeLadderHeight(scanner.nextLine());
    }

    int makeLadderHeight(String input) {
        try {
            checkLadderHeightInputAccuracy(input);
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderHeight();
        }
    }

    private void checkLadderHeightInputAccuracy(String input) {
        if (isHeightEmpty(input)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_HAS_VALUE_EMPTY);
        }
        if (!isIntegerNumber(input.trim())) {
            throw new NumberFormatException(MessageCollection.ERROR_NOT_INTEGER);
        }
        if (Integer.parseInt(input.trim()) < MIN_HEIGHT) {
            throw new IllegalArgumentException(MessageCollection.ERROR_LOWER_MIN_HEIGHT);
        }
    }

    private boolean isHeightEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isIntegerNumber(String input) {
        return Pattern.matches("-?[1-9]\\d*|0", input);
    }

    public List<LadderGoal> makeLadderGoals(int numOfPlayers) {
        System.out.println(ENTER + MessageCollection.INPUT_LADDER_GOAL_NAME);
        return makeLadderGoals(scanner.nextLine().split(DELIMITER), numOfPlayers);
    }

    List<LadderGoal> makeLadderGoals(String[] inputs, int numOfPlayers) {
        try {
            checkLadderGoalInputAccuracy(inputs, numOfPlayers);
            return Arrays.stream(inputs).map(String::trim).map(LadderGoal::new).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderGoals(numOfPlayers);
        }

    }

    private void checkLadderGoalInputAccuracy(String[] inputs, int numOfPlayers) {
        if (!isMatchPlayersAndGoals(inputs, numOfPlayers)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_MISMATCH_PLAYERS_AND_GOALS);
        }
        if (isOverlapLadderGoal(inputs)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_OVERLAP_GOAL_NAME);
        }
    }

    private boolean isMatchPlayersAndGoals(String[] inputs, int numOfPlayers) {
        return inputs.length == numOfPlayers;
    }

    private boolean isOverlapLadderGoal(String[] inputs) {
        Set<String> checkOverlapGoalNames = new HashSet<>(Arrays.asList(inputs));
        return checkOverlapGoalNames.size() != inputs.length;
    }

    public static String findName() {
        System.out.println(ENTER + MessageCollection.INPUT_FIND_NAME);
        return scanner.nextLine();
    }
}
