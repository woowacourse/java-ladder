package controller;

import domain.model.Goods;
import domain.model.Ladder;
import domain.service.LadderMaker;
import view.InputView;
import view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;
    public GameController(InputView inputView, OutputView outputView, LadderMaker ladderMaker){
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }
    public void checkResult(){

    }
}
