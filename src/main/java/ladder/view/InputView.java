package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String input = scanner.nextLine();

        return parseStringToList(input);
    }

    public int readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String input = scanner.nextLine();

        return parseToInt(input);
    }

    private List<String> parseStringToList(String input) {
        return Arrays.stream(input.split(",", -1)).toList();
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자여야 합니다.");
        }
    }
}
