package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }


    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = new ArrayList<>(List.of(splitNames(input)));
        validateDuplicatedNames(names);
        return names;
    }

    private String[] splitNames(String input) {
        return input.split(",");
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }
}
