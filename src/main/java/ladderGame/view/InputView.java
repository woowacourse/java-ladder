package ladderGame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class InputView {
    private final Scanner scanner;
     private static final String INPUT_MESSAGE_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public InputView() {
        scanner = new Scanner(System.in);
    }
    public List<String> inputPlayerNames() {
        System.out.println(INPUT_MESSAGE_PLAYER_NAMES);
        return Arrays.stream(scanner.nextLine().split(",", -1)).toList();
    }

}
