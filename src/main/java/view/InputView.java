package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayersName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String rawNames = scanner.nextLine();
        if (rawNames == null || rawNames.trim().isEmpty()) {
            // TODO: 예외 메시지
            throw new IllegalArgumentException();
        }

        validateSeparators(rawNames);
        List<String> names = List.of(rawNames.split(",", -1));

        return names;
    }

    private void validateSeparators(String rawNames) {
        if(rawNames.startsWith(",") || rawNames.endsWith(",") || rawNames.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }

    public int readHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String rawHeight = scanner.nextLine();
        if(rawHeight == null || rawHeight.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return convert(rawHeight);
    }

    private int convert(String rawHeight) {
        try {
            validatePositiveNumber(rawHeight);
            return Integer.parseInt(rawHeight);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(); //TODO: 예외메시지
        }
    }

    private void validatePositiveNumber(String rawHeight) {
        int height = Integer.parseInt(rawHeight);
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
