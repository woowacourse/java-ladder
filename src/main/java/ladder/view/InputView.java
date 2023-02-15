package ladder.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NUMBER = Pattern.compile("^-?\\d+$");

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String height = scanner.nextLine();
        if (!NUMBER.matcher(height).matches()) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다");
        }
        return Integer.parseInt(height);
    }
}
