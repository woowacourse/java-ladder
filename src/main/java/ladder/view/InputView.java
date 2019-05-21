package ladder.view;

import ladder.domain.Items;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.domain.ThrowException;

import java.util.Scanner;

/**
 * @author heebg
 * @version 1.0 2019-05-19
 */
public class InputView {
    private static final int MIN_DEPTH_RANGE = 1;
    private static final String INPUT_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)(이름 중복, all은 안됨)";
    private static final String INPUT_ITEMS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_DEPTH = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANT_NAME = "결과를 보고싶은 사람의 이름을 입력하세요(전부 보고 싶으면 all을 입력하세요)";
    private static final String EX_DEPTH = "길이는 " + MIN_DEPTH_RANGE + " 이상이어야합니다.";
    private static final String EX_NOT_MATCH_NAME = "해당하는 이름이 없습니다.";

    private final static Scanner SCANNER = new Scanner(System.in);

    public static Players inputPlayers(String names) {
        try {
            return Players.newInstance(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayers(inputPlayersFromUser());
        }
    }

    public static String inputPlayersFromUser() {
        System.out.println(INPUT_PLAYERS);
        return SCANNER.nextLine();
    }

    public static Items inputItems(String names, int size) {
        try {
            return Items.newInstance(names, size);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputItems(inputItemsFromUser(), size);
        }
    }

    public static String inputItemsFromUser() {
        System.out.println();
        System.out.println(INPUT_ITEMS);
        return SCANNER.nextLine();
    }

    public static int inputDepth(int depth) {
        try {
            ThrowException.checkArgument(depth < MIN_DEPTH_RANGE, EX_DEPTH);
            return depth;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputDepth(inputDepthFromUser());
        }
    }

    public static int inputDepthFromUser() {
        try {
            System.out.println(INPUT_DEPTH);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println(EX_DEPTH);
            return inputDepthFromUser();
        }
    }

    public static String inputName(String name, LadderResult result) {
        try {
            return result.findMatchItem(name);
        } catch (Exception e) {
            System.out.println(EX_NOT_MATCH_NAME);
            return inputName(inputNameFromUser(), result);
        }
    }

    public static String inputNameFromUser() {
        System.out.println(INPUT_WANT_NAME);
        return SCANNER.nextLine();
    }

}
