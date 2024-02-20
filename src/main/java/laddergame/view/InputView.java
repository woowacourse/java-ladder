package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        final String input = scanner.nextLine();

        return Arrays.stream(input.split(","))
                .toList();
    }

}
