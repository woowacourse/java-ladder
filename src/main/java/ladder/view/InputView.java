package ladder.view;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(in);

    public List<String> readNames() {
        out.println(lineSeparator() + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String rawNames = scanner.nextLine();
        return List.of(rawNames.split(DELIMITER));
    }

    public int readHeight() {
        out.println(lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
