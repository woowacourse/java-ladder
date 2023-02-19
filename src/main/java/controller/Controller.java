package controller;

import model.Ladder;
import model.LadderHeight;
import model.LadderResult;
import model.Names;
import view.InputView;
import view.OutputView;

public class Controller {

    public InputView inputView;
    public OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Names names = setNames();
        LadderResult ladderResult = setLadderResult(names.getNamesSize());
        LadderHeight ladderHeight = setLadderHeight();
        Ladder ladder = new Ladder(names.getNamesSize(), ladderHeight);
        printResult(names, ladder, ladderHeight);
    }

    private Names setNames() {
        outputView.printPlayerNamesMessage();
        try {
            return new Names(inputView.readPlayerNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setNames();
        }
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        try {
            return new LadderHeight(inputView.readLadderHeight());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }

    private LadderResult setLadderResult(int personCount) {
        outputView.printLadderResultMessage();
        try {
            return new LadderResult(inputView.readLadderResult(),personCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setLadderResult(personCount);
        }
    }

    private void printResult(Names names, Ladder ladder, LadderHeight ladderHeight){
        outputView.printResultMessage();
        outputView.printName(names);
        outputView.printLadder(names, ladder, ladderHeight);
    }
}
