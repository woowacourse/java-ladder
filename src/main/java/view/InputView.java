package view;

import utils.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        printMessage(NAME_INPUT_MESSAGE);
        String inputNames = scanner.nextLine();
        return Parser.parse(inputNames, DELIMITER);
    }

    public int readLadderHeight() {
        printMessage(HEIGHT_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
