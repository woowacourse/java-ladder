import controller.LadderGameController;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.play();
        scanner.close();
    }
}
