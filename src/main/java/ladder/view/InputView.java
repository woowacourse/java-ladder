package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.domain.Height;
import ladder.domain.Players;
import ladder.exception.ExceptionHandler;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Players inputNames() {
        return ExceptionHandler.run(() -> {
            System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> names = Arrays.asList(readLine().split(","));
            return new Players(names);
        });
    }

    public static Height inputHeight() {
        return ExceptionHandler.run(() -> {
            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            return new Height(Integer.parseInt(readLine()));
        });
    }

    private static String readLine() {
        return SCANNER.nextLine().replace(" ", "");
    }
}
