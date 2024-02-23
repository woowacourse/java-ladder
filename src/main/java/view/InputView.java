package view;

import util.ExceptionMessages;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final InputView instance = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static final InputView getInstance() {
        return instance;
    }

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String rawNames = scanner.nextLine().trim();
        return List.of(rawNames.split(DELIMITER));
    }

    public int readHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_HEIGHT_FORMAT);
        }
    }
}
