package view;

import java.util.List;
import java.util.Scanner;
import parser.NameParser;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String text = scanner.next();
        return NameParser.parse(text);
    }

    public List<String> inputPresentNames() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String text = scanner.next();
        return NameParser.parse(text);
    }

    public int inputHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String inputFinding() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
