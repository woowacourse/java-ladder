package view;

import domain.Player;
import domain.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PARTICIPATED_PLAYERS = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_EXECUTED_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_RESULT_PLAYER = "\n결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> readPlayerNames() {
        System.out.println(MESSAGE_PARTICIPATED_PLAYERS);
        String input = scanner.nextLine().replaceAll(" ", "");
        return Arrays.stream(input.split(","))
                .map(Player::new)
                .toList();
    }

    public static List<Result> readResults() {
        System.out.println(MESSAGE_EXECUTED_RESULT);
        String input = scanner.nextLine().replaceAll(" ", "");
        return Arrays.stream(input.split(","))
                .map(Result::new)
                .toList();
    }

    public static int readLadderHeight() throws NumberFormatException {
        System.out.println(MESSAGE_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readPlayer() {
        System.out.println(MESSAGE_RESULT_PLAYER);
        return scanner.nextLine();
    }
}
