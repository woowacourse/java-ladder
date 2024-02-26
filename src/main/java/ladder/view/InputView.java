package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.domain.Height;
import ladder.domain.Players;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(readLine().split(","));
        return new Players(names);
    }

    public static List<String> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(readLine().split(","));
    }

    public static Height inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return new Height(readInt());
    }

    private static String readLine() {
        return SCANNER.nextLine().replace(" ", "");
    }

    private static int readInt() {
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("입력이 정수가 아닙니다: " + input);
        }
    }
}
