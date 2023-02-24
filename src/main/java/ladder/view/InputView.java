package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return List.of(names.split(","));
    }

    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public List<String> askResultProducts() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String products = scanner.nextLine();
        return List.of(products.split(","));
    }

    private void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자여야 합니다.");
        }
    }

    public String askResultByPlayerName() {
        System.out.println("결과를 보고 싶은 사람은? (전부 보고싶으면 all 을 입력하세요)");
        return scanner.nextLine();
    }
}
