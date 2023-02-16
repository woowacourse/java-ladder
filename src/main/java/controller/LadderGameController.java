package controller;

import domain.Ladder;
import domain.Name;
import domain.Names;
import dto.GameDto;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    public void run(){
        Names names = getNames();
        int height = getHeight();
        Ladder ladder = new Ladder();
        ladder.build(height, names.count());
        OutputView.printResult(new GameDto(names, ladder));
    }

    private Names getNames(){
        OutputView.printRequestNames();
        return new Names(Name.of(InputView.getNames()));
    }

    private int getHeight(){
        OutputView.printRequestLadderHeight();
        return InputView.getHeight();
    }
}
