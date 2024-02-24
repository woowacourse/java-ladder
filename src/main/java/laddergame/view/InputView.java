package laddergame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of(scanner.nextLine()
                        .split(DELIMITER));
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하의 자연수여야 합니다");
        }
    }
}
