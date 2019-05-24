package ladder.view;

import ladder.domain.gamecomponent.Ladder;
import ladder.domain.gamecomponent.PlayerName;
import ladder.domain.gamecomponent.Results;
import ladder.domain.stepgenerator.RandomStepsGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DEMAND_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DEMAND_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String DEMAND_LADDER_HEIGHT = "최대 사다리 높이는 얼마인가요?";
    private static final String VIOLATE_LADDER_HEIGHT = "사다리의 높이를 숫자로 입력해주세요.";
    private static final String DEMAND_PLAYER_NAME_FOR_RESULT = "\n결과를 보고 싶은 사람은?";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println(DEMAND_PLAYER_NAMES);
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
        System.out.println(DEMAND_RESULTS);
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
        System.out.println(DEMAND_LADDER_HEIGHT);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(VIOLATE_LADDER_HEIGHT);
            return inputHeight();
        }
    }

    public static Ladder createLadder(int playerNum) {
        int height = inputHeight();

        try {
            return new Ladder(new RandomStepsGenerator(playerNum), height);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return createLadder(playerNum);
        }
    }

    public static String inputNameForResult() {
        System.out.println(DEMAND_PLAYER_NAME_FOR_RESULT);
        return scanner.nextLine();
    }

    public static String getNameForResult() {
        try {
            String input = inputNameForResult();
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNameForResult();
        }
    }
}
