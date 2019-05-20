package ladder.view;

import ladder.domain.LadderGamePlayers;
import ladder.domain.LadderGameRewards;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ladder.view.constants.InputViewConstants.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCountOfLines() {
        OutputView.printMassage(GET_COUNT_OF_LINES_MESSAGE);
        try {
            int CountOfLines = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return CountOfLines;
        } catch (NumberFormatException ne) {
            OutputView.printMassage(NUMBER_FORMAT_EXCEPTION_MASSAGE);
            return getCountOfLines();
        }
    }

    static String getResult(){
        OutputView.printMassage(GET_RESULT_MESSAGE);
        String result = scanner.nextLine();
        System.out.println();
        return result;
    }

    public static LadderGamePlayers createPlayers() {
        OutputView.printMassage(GET_NAME_MESSAGE);
        List<String> names = inputCommaDelimiter();
        try {
            return new LadderGamePlayers(names);
        } catch (IllegalArgumentException ie) {
            OutputView.printMassage(ie.getMessage());
            return createPlayers();
        }
    }

    private static List<String> inputCommaDelimiter() {
        List<String> strings = Arrays.asList(scanner.nextLine().split(","));
        OutputView.printMassage(NEXT_LINE);
        return strings;
    }

    public static LadderGameRewards createRewards(int countOfPlayers) {
        System.out.println(GET_DRAW_RESULT_MESSAGE);
        List<String> rewards = inputCommaDelimiter();
        try {
            checkCount(countOfPlayers, rewards.size());
            return new LadderGameRewards(rewards);
        } catch (IllegalArgumentException ie) {
            OutputView.printMassage(ie.getMessage());
            return createRewards(countOfPlayers);
        }
    }

    private static void checkCount(int countOfPlayers, int countOfResults) {
        if (countOfPlayers != countOfResults) {
            throw new IllegalArgumentException(INVALID_LENGTH_REWARDS_EXCEPTION_MASSAGE);
        }
    }
}
