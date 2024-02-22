package view;

import dto.HeightRequest;
import dto.PlayersRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_NAMES_DELIMITER = ",";

    private final Scanner scanner;
    private final InputValidator inputValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public PlayersRequest inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        inputValidator.validatePlayers(input);
        List<String> players = Arrays.asList(input.split(INPUT_NAMES_DELIMITER));
        List<String> trimedPlayers = players.stream()
                .map(String::trim)
                .toList();
        return new PlayersRequest(trimedPlayers);
    }

    public HeightRequest inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        inputValidator.validateHeight(input);
        return new HeightRequest(Integer.parseInt(input));
    }
}
