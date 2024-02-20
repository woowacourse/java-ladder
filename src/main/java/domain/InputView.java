package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final InputValidator inputValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public List<String> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        inputValidator.validatePlayers(input);
        String[] players = input.split(",");
        return Arrays.asList(players);
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        inputValidator.validateHeight(input);
        return Integer.parseInt(input);
    }
}
