package ladder.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return List.of(names.split(","));
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputNumericHeight();
    }

    private int inputNumericHeight() {
        int height;
        try {
            height = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("사다리 높이는 자연수만 입력할 수 있습니다.");
        }
        scanner.nextLine();
        return height;
    }

    public List<String> inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return List.of(names.split(","));
    }

    public String inputPlayerForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
