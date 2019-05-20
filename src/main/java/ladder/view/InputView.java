package ladder.view;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println(UserOutput.DEMAND_PLAYER_NAMES.getOutputMessage());
        return scanner.nextLine();
    }

    public static List<PlayerName> getNames() {
        try {
            String input = inputNames();
            return createNames(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNames();
        }
    }

    private static List<PlayerName> createNames(String input) {
        List<PlayerName> names = new ArrayList<>();

        for (String name : input.split(",")) {
            names.add(new PlayerName(name));
        }
        return names;
    }

    public static String inputResults() {
        System.out.println(UserOutput.DEMAND_GAME_RESULTS.getOutputMessage());
        return scanner.nextLine();
    }

    public static Results getResult(int playerNum) {
        try {
            String input = inputResults();
            return new Results(Arrays.asList(input.split(",")), playerNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResult(playerNum);
        }
    }

    public static int inputHeight() {
        System.out.println(UserOutput.DEMAND_LADDER_HEIGHT.getOutputMessage());

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(UserOutput.VIOLATE_LADDER_HEIGHT.getOutputMessage());
            return inputHeight();
        }
    }

    public static Ladder createLadder(int playerNum) {
        int height = inputHeight();

        try {
            return new Ladder(playerNum, height);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return createLadder(playerNum);
        }
    }

    public static String inputNameForResult() {
        System.out.println(UserOutput.DEMAND_PLAYER_NAME_FOR_RESULT.getOutputMessage());
        return scanner.nextLine();
    }
}
