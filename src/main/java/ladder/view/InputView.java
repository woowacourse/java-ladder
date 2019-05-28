package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String MATCHING_FINISHED_MESSAGE = "-1";

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String NAME_SEPERATOR = ",";

    public static List<String> readPlayers(String notifyingMessage) {
        System.out.println(notifyingMessage);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            return splitNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            return readPlayers(e.getMessage());
        }
    }

    public static List<String> readRewards(String notifyingMessage) {
        System.out.println(notifyingMessage);
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            return splitNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRewards(notifyingMessage);
        }
    }

    private static List<String> splitNames(String inp) {
        inp = inp.replace(SPACE, EMPTY);
        return Arrays.asList(inp.split(NAME_SEPERATOR));
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("높이는 숫자여야 합니다");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readHeight();
    }

    public static String readExistPlayer(String notifyingMessage) {
        System.out.println(notifyingMessage);
        System.out.println("결과를 보고 싶은 사람은? (모두 확인하려면 'all'을 입력하세요, 종료하시려면 '-1'를 입력해주세요)");
        try {
            return SCANNER.nextLine();
        } catch (IllegalArgumentException e) {
            return readExistPlayer(e.getMessage());
        }
    }
}
