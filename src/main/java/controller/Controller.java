package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Result;
import domain.Results;
import domain.User;
import domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import utils.LadderRowGenerator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final LadderRowGenerator ladderRowGenerator;

    public Controller(final LadderRowGenerator ladderRowGenerator) {
        this.ladderRowGenerator = ladderRowGenerator;
    }

    public void run() {
        Users users = getUsers();
        Results results = getResults();
        Height height = getHeight();

        Ladder ladder = getLadder(users, height);
        LadderGame ladderGame = getLadderGame(ladder, users);

        OutputView.printResult(users, results, ladder);
        String resultViewer = InputView.readResultViewer();
        int departureIndex = users.findByName(resultViewer);
        int arrivalIndex = ladderGame.move(departureIndex, 0, height.getHeight());
        System.out.println(results.getResults().get(arrivalIndex).getResultName());
    }

    private Users getUsers() {
        try {
            List<String> userNames = InputView.readUserNames();
            List<User> users = userNames.stream()
                    .map(User::new)
                    .collect(Collectors.toList());
            return new Users(users);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getUsers();
        }
    }

    private Results getResults() {
        try {
            List<String> resultNames = InputView.readResultNames();
            List<Result> results = resultNames.stream()
                    .map(Result::new)
                    .collect(Collectors.toList());
            return new Results(results);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getResults();
        }
    }

    private Height getHeight() {
        try {
            int height = InputView.readLadderHeight();
            return new Height(height);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getHeight();
        }
    }

    private Ladder getLadder(final Users users, final Height height) {
        return new Ladder(users.getSize(), height.getHeight(), ladderRowGenerator);
    }

    private LadderGame getLadderGame(final Ladder ladder, final Users users) {
        return new LadderGame(ladder, users);
    }
}
