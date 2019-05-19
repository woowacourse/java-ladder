package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> readName() {
        System.out.println(ConsoleMessages.INPUT_NAME.message());
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static String readHeight() {
        System.out.println(ConsoleMessages.INPUT_HEIGHT.message());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String readReward() {
        System.out.println(ConsoleMessages.INPUT_REWARD.message());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String readPlayer() {
        System.out.println(ConsoleMessages.INPUT_PLAYER.message());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
