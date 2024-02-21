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

        List<String> names = List.of(rawNames.split(","));
        return names;
    }

    public void readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
