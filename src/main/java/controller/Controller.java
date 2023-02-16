package controller;

import model.Ladder;
import model.LadderHeight;
import model.Names;
import model.Players;
import view.InputView;
import view.OutputView;

public class Controller {

    public InputView inputView;
    public OutputView outputView;

    public Controller(InputView inputView,OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        Players players= new Players(setPlayerNames());
        LadderHeight ladderHeight = setLadderHeight();
        Ladder ladder = new Ladder(players, ladderHeight);
        outputView.printAllPlayerNames(players);
        outputView.printLadder(ladder);
    }

    private Names setPlayerNames(){
        outputView.printPlayerNamesMessage();
        return inputView.readPlayerNames();
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        return inputView.readLadderHeight();
    }
}
