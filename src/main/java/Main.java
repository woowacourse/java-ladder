import controller.LadderGame;
import view.InputView;
import view.OutputView;

class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderGame ladderGame = new LadderGame(inputView, outputView);

        ladderGame.play();
    }
}
