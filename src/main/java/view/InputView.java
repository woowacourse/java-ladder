package view;

import model.LadderHeight;
import model.Name;
import model.NameFactory;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Name> readPlayerNames() {
        return NameFactory.create(scanner.nextLine());
    }

    public LadderHeight readLadderHeight() {
        return new LadderHeight(scanner.nextInt());
    }
}
