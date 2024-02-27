package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String input = readLine();

        return parseStringToList(input);
    }

    public int readLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String input = readLine();

        return parseToInt(input);
    }

    public List<String> readPrizeNames(int playerCount) {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String input = readLine();
        List<String> prizeNames = parseStringToList(input);

        validatePrizeSize(playerCount, prizeNames.size());

        return prizeNames;
    }

    private void validatePrizeSize(int playerCount, int prizeCount) {
        if (playerCount != prizeCount) {
            throw new IllegalArgumentException("참가자 수와 결과 수가 일치해야 합니다.");
        }
    }

    public String readSelectedPlayerName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");

        return readLine();
    }

    private String readLine() {
        String input = scanner.nextLine();

        validateInputEmpty(input);

        return input;
    }

    private void validateInputEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값은 비어있을 수 없습니다.");
        }
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자여야 합니다.");
        }
    }

    private List<String> parseStringToList(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::strip)
                .toList();
    }
}
