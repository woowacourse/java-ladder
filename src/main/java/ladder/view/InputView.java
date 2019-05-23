package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputPlayerName(){
        return inputName("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static List<String> inputResultName(){
        return inputName("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static List<String> inputName(String inputMessage) {
        System.out.println(inputMessage);
        String resultNames = SCANNER.nextLine();
        return Arrays.asList(resultNames.split(","));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputPlayerNameToShowResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine().trim();
    }
}
