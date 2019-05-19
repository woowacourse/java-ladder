package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ladder.view.constants.InputViewConstants.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println(GET_NAME_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static List<String> getRewards() {
        System.out.println(GET_DRAW_RESULT_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int getCountOfLines() {
        System.out.println(GET_COUNT_OF_LINES_MESSAGE);
        return scanner.nextInt();
    }

    public static String getResult(){
        System.out.println(GET_RESULT_MESSAGE);
        return scanner.nextLine();
    }
}
