package controller;

import domain.game.Game;
import domain.game.Results;
import domain.ladder.Ladder;
import domain.user.Users;
import java.util.List;
import java.util.Map;
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
        ladder = new Ladder(users.getPersonCount(), initializeHeight());
    }

    public void run() {
        printGameSet();
        Map<String, String> resultMap = playGame();
        String findUser;
        do {
            findUser = findUserResult();
        }
        while (outputView.printResultByUser(resultMap, findUser, users.getUserNames()));
    }

    private Map<String, String> playGame() {
        Game game = new Game(users.getUserNames(), ladder.getLines());
        game.executeGame();
        return game.getLadderResult(results);
    }

    private void printGameSet() {
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
            return new Users(userNames);
        } catch (IllegalArgumentException e) {
            return initializeUsers();
        }
    }

    private int initializeHeight() {
        try {
            return inputView.inputLadderHeight();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initializeHeight();
        }
    }

    private String findUserResult() {
        try {
            String checkNameInput = inputView.inputResultUser();
            users.checkNameInUsers(checkNameInput);
            return checkNameInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return findUserResult();
        }
    }
}
