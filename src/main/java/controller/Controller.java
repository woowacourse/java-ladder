package controller;

import model.LadderHeight;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    public InputView inputView;
    public OutputView outputView;

    public Controller(InputView inputView,OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        List<String> playerNames = setPlayerNames();
        LadderHeight ladderHeight = setLadderHeight();
    }

    private List<String> setPlayerNames(){
        outputView.printPlayerNamesMessage();
        return inputView.readPlayerNames();
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        return inputView.readLadderHeight();
    }
}
