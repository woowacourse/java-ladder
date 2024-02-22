package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import validator.HeightInputValidator;
import validator.PlayersInputValidator;

public class InputView {
    private static final String DEFAULT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String rawNames = scanner.nextLine();
        PlayersInputValidator.validate(rawNames);
        return Arrays.asList(rawNames.split(DEFAULT_DELIMITER));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String rawHeight = scanner.nextLine();
        HeightInputValidator.validate(rawHeight);
        return Integer.parseInt(rawHeight);
    }
}
