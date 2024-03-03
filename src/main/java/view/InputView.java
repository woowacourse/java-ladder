package view;

import domain.StringParser;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String rawNames = sc.nextLine();
        return StringParser.splitByDelimiter(rawNames, ",");
    }

    public List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String rawResults = sc.nextLine();
        return StringParser.splitByDelimiter(rawResults, ",");
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String rawHeight = sc.nextLine();
        return StringParser.stringToInt(rawHeight);
    }

    public String readTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }
}
