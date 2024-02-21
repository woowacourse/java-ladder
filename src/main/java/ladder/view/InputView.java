package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.domain.People;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static People inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(readLine().split(","));
        return new People(names);
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readLine());
    }

    private static String readLine() {
        return scanner.nextLine().replaceAll(" ", "");
    }
}
