package view;

import domain.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.validator.LadderSizeValidator;

public class InputView {
    private static final InputView instance = new InputView();
    private static final Scanner scanner = new Scanner(System.in);

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<Name> readNames() {
        String input = readInput(Message.INPUT_NAMES.message);
        List<Name> names = new ArrayList<>();
        for (String name : input.split(",")) {
            names.add(new Name(name.trim()));
        }
        return names;
    }

    public int readLadderSize() {
        String input = readInput(Message.INPUT_LADDER_SIZE.message);
        LadderSizeValidator.validate(input);
        return Integer.parseInt(input);
    }

    private static String readInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private enum Message {
        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_LADDER_SIZE("최대 사다리 높이는 몇 개인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
