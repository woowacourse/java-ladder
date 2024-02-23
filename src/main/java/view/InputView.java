package view;

import domain.Height;
import domain.name.Names;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Names readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(scanner.nextLine().split(","));
        return Names.from(names);
    }

    public Height readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String height = scanner.nextLine();
        validateInputNumeric(height);
        return new Height(Integer.parseInt(height));
    }

    private void validateInputNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값이 아닙니다");
        }
    }
}
