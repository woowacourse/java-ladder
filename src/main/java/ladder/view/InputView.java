package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ladder.view.constants.InputViewConstants.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println(GET_NAME_MESSAGE);
        List<String> names = Arrays.asList(scanner.nextLine().split(","));
        System.out.println();
        return names;
    }

    public static List<String> getRewards() {
        System.out.println(GET_DRAW_RESULT_MESSAGE);
        List<String> rewards = Arrays.asList(scanner.nextLine().split(","));
        System.out.println();
        return rewards;
    }

    public static int getCountOfLines() {
        System.out.println(GET_COUNT_OF_LINES_MESSAGE);
        try {
            int CountOfLines = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return CountOfLines;
        } catch (NumberFormatException ne) {
            System.out.println("숫자를 입력하세요.");
            return getCountOfLines();
        }
    }

    public static String getResult(){
        System.out.println(GET_RESULT_MESSAGE);
        String result = scanner.nextLine();
        System.out.println();
        return result;
    }
}
