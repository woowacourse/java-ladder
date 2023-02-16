package view;

import utils.StringParser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNames = scanner.nextLine();
        return StringParser.splitByDelimiter(userNames);
    }

    public static int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = scanner.nextLine();
        return StringParser.parseToInteger(ladderHeight);
    }
}
