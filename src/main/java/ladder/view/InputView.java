package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String QUERY_ALL = "all";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.reset().nextLine();
        System.out.println();
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    public static int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.reset().nextLine();
        return Integer.parseInt(input);
    }

    public static List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.reset().nextLine();
        System.out.println();
        return Arrays.stream(results.split(",")).collect(Collectors.toList());
    }

    public static String readInquireName() {
        scanner.reset();
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
