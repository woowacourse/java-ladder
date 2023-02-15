package view;

import domain.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.validator.LadderSizeValidator;

public class InputView {
    private static final InputView instance = new InputView();
    private static final Scanner scanner = new Scanner(System.in);

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public List<Name> readNames() {
        String input = scanner.nextLine();
        List<Name> names = new ArrayList<>();
        for (String name : input.split(",")) {
            names.add(new Name(name.trim()));
        }
        return names;
    }

    public int readLadderSize() {
        String input = scanner.nextLine();
        LadderSizeValidator.validate(input);
        return Integer.parseInt(input);
    }
}
