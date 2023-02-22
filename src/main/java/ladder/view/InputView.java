package ladder.view;

import java.util.List;

public class InputView {

    public static List<String> askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return ConsoleReader.readLineByDelimiter(",");
    }

    public static List<String> askLadderResults() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return ConsoleReader.readLineByDelimiter(",");
    }

    public static int askLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return ConsoleReader.readNaturalNumber();
    }

    public static String askPlayerNameForResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return ConsoleReader.readLine();
    }
}
