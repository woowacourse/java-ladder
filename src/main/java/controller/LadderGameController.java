package controller;

import domain.Results;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.user.User;
import domain.user.Users;
import java.util.ArrayList;
import java.util.List;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Users users;
    private Ladder ladder;
    private Results results;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void initialize() {
        users = initializeUsers();
        results = initializeResults();
        ladder = createLadder(users.getPersonCount(), initializeHeight());
    }

    public void run() {
        outputView.printUserNames(users);
        outputView.printLadder(ladder);
        outputView.printResults(results);
    }

    private Results initializeResults() {
        try {
            return new Results(inputView.inputResults(), users.getPersonCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeResults();
        }
    }

    private Users initializeUsers() {
        try {
            List<String> userNames = inputView.inputUserName();
            return new Users(createUsers(userNames));
        } catch (IllegalArgumentException e) {
            return initializeUsers();
        }
    }

    private List<User> createUsers(List<String> userNames) {
        List<User> users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
        return users;
    }

    private int initializeHeight() {
        try {
            return inputView.inputLadderHeight();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeHeight();
        }
    }

    public Ladder createLadder(int personCount, int height) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Line> lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount, randomNumberGenerator));
        }
        return new Ladder(lines, height);
    }
}
