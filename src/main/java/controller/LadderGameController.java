package controller;

import model.Ladder;
import model.LadderHeight;
import model.Name;
import model.Players;
import model.Result;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {
    public InputView inputView;
    public OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(setPlayerNames());
        List<Result> results = setResults(players.size());
        Ladder ladder = new Ladder(players, setLadderHeight());
        outputView.printAllPlayerNames(players.getAllPlayerNames());
        outputView.printLadder(ladder);
    }

    private List<Result> setResults(int playerCount) {
        outputView.printResultsMessage();
        return inputView.readResults(playerCount);
    }

    private List<Name> setPlayerNames() {
        outputView.printPlayerNamesMessage();
        return inputView.readPlayerNames();
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        return inputView.readLadderHeight();
    }
}
