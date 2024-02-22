package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = scanner.nextLine().trim();
        return Arrays.stream(inputNames.split(",")).toList();
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputHeight = scanner.nextLine();
        int height;
        try {
            height = Integer.parseInt(inputHeight);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("높이는 정수여야 합니다.");
        }
        return height;
    }
}
