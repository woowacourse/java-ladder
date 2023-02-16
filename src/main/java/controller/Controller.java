package controller;

import model.Ladder;
import model.LadderHeight;
import model.Names;
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
        Names names = setNames();
        LadderHeight ladderHeight = setLadderHeight();
        Ladder ladder = new Ladder(names,ladderHeight);
        outputView.printName(names);
        outputView.printLadder(names,ladder,ladderHeight);
    }

    private Names setNames(){
        outputView.printPlayerNamesMessage();
        try {
            Names names = new Names(inputView.readPlayerNames());
            return names;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return setNames();
        }
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        try {
            LadderHeight ladderHeight = new LadderHeight(inputView.readLadderHeight());
            return ladderHeight;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }
}
