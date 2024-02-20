package Controller;

import domain.InputView;
import domain.OutputView;
import domain.Players;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> rawPlayers = inputView.inputPlayers();
        int height = inputView.inputHeight();
        Players players = new Players(rawPlayers);
    }
}
