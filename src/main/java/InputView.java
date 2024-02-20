import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public InputView() {
    }

    private static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String initialInput = input();
        return Arrays.stream(initialInput.split(","))
                     .map(String::trim)
                     .toList();
    }

    public static String inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return input();
    }
}
