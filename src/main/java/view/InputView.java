package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class InputView {
    public static final String DELIMITER = ",";
    public static final String DELIMITER_KOREAN = "쉼표";

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator;

    private InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public static InputView create() {
        return new InputView(new InputValidator());
    }

    public List<String> inputPlayers() {
        printLine("참여할 사람 이름을 입력하세요. (이름은 " + DELIMITER_KOREAN + "(" + DELIMITER + ")로 구분하세요)");
        final String input = readLineWithTrim();
        inputValidator.validatePlayers(input);

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public List<String> inputPrizes(final int playerCount) {
        printLine("실행 결과를 입력하세요. (결과는 " + DELIMITER_KOREAN + "(" + DELIMITER + ")로 구분하세요)");
        final String input = readLineWithTrim();
        inputValidator.validatePrizes(input, playerCount);

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int inputHeight() {
        printLine("최대 사다리 높이는 몇 개인가요?");
        final String input = readLineWithTrim();
        inputValidator.validateHeight(input);

        return Integer.parseInt(input);
    }

    public String inputSearchingPlayer() {
        printLine("결과를 보고 싶은 사람은?");
        final String input = readLineWithTrim();
        inputValidator.validateSearchingPlayer(input);

        return input;
    }

    public void printLine(final String message) {
        System.out.println(message);
    }

    public String readLineWithTrim() {
        return scanner.nextLine().trim();
    }
}
