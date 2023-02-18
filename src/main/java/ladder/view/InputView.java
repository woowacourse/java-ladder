package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return List.of(names.split(","));
    }

    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자여야 합니다.");
        }
    }
}
