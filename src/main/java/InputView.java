import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    public static String receivePlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playerNames = scanner.nextLine();
        isBlank(playerNames);

        return playerNames;
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }
}
