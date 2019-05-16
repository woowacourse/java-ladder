package ladder.view;

import java.util.Scanner;

public class InputView {
    public InputView() {
    }

    public String readName() {
        System.out.println(ConsoleMessages.INPUT_NAME.message());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String readHeight() {
        System.out.println(ConsoleMessages.INPUT_HEIGHT.message());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String readReward() {
        System.out.println("reward");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public String readPlayer() {
        System.out.println("플");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
