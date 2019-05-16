package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputPlayerName(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = SCANNER.nextLine();
        return Arrays.asList(playerNames.split(","));
    }

    public static String inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextLine();
    }

    public static List<String> inputResultName(){
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String resultNames = SCANNER.nextLine();
        return Arrays.asList(resultNames.split(","));
    }
}
