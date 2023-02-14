package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";
    public static final int MIN_PERSON_COUNT = 2;

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = readLine();
        validateDelimiter(input);
        List<String> result = Arrays.stream(input.split(DELIMITER))
            .collect(Collectors.toList());
        validatePersonCount(result);
        validateDuplicate(result);
        return result;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private void validateDelimiter(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(",로 끝날 수 없습니다");
        }
    }

    private void validatePersonCount(List<String> result) {
        if (result.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사람은 두 명 이상이어야 합니다.");
        }
    }

    private void validateDuplicate(List<String> result) {
        if (result.size() != result.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.", exception);
        }
    }
}
