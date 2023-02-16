package controller;

import model.LadderHeight;
import model.Names;
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
        Names playerNames = setPlayerNames();
        LadderHeight ladderHeight = setLadderHeight();
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
