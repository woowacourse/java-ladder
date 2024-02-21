package Controller;

import domain.*;
import dto.HeightRequest;
import dto.PlayersRequest;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PlayersRequest playersRequest = inputView.inputPlayers();
        Players players = playersRequest.toPlayers();
        HeightRequest heightRequest = inputView.inputHeight();
        Height height = heightRequest.toHegith();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Carpenter carpenter = new Carpenter(height, PlayerCount.fromPlayers(players), numberGenerator);
        Ladder ladder = carpenter.makeLadder();

        outputView.printResult(players, ladder);
    }
}
