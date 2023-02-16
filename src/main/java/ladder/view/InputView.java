package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        String names = scanner.reset().nextLine();
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }
}
