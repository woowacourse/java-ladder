package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NAMES_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesInput = scanner.nextLine();
        return asList(namesInput);
    }

    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String heightString = scanner.nextLine();
        return parseInt(heightString);
    }

    private int parseInt(String heightString) {
        try {
            return Integer.parseInt(heightString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자입니다");
        }
    }

    public List<String> readGameResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String gameResultsInput = scanner.nextLine();
        return asList(gameResultsInput);
    }

    private List<String> asList(String inputString) {
        String[] strings = inputString.split(NAMES_DELIMITER);
        return Arrays.asList(strings);
    }

    public String readScopeOfResultChecking() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
