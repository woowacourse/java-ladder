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
        final PlayersRequest playersRequest = inputView.inputPlayers();
        final Players players = playersRequest.toPlayers();
        final HeightRequest heightRequest = inputView.inputHeight();
        final Height height = heightRequest.toHegith();

        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        final Carpenter carpenter = new Carpenter(height, PlayerCount.fromPlayers(players), numberGenerator);
        final Ladder ladder = carpenter.makeLadder();

        outputView.printResult(players, ladder);
    }
}
