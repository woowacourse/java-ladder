package view;

import model.VO.LadderHeight;
import model.VO.Name;
import model.factory.NameFactory;
import model.VO.Result;
import model.factory.ResultFactory;

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
        return new LadderHeight(Integer.parseInt(scanner.nextLine()));
    }

    public List<Result> readResults(int playerCount) {
        return ResultFactory.create(playerCount, scanner.nextLine());
    }

    public Name readDesirousResultName() {
        return new Name(scanner.nextLine());
    }
}
