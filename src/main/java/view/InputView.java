package view;

import model.LadderHeight;
import model.Name;
import model.NameFactory;
import model.Result;
import model.ResultFactory;

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

    public List<Result> readResults(int playerCount) {
        return ResultFactory.create(playerCount, scanner.nextLine());
    }

    public Name readDesirousResultName() {
        return new Name(scanner.nextLine());
    }
}
