package controller;

import model.Ladder;
import model.LadderHeight;
import model.Name;
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
        List<Name> playerNames = setPlayerNames();
        Ladder ladder = new Ladder(playerNames.size(),setLadderHeight());
        outputView.printPlayerName(playerNames);
        outputView.printLadder(playerNames.size(),ladder);
    }

    private List<Name> setPlayerNames(){
        outputView.printPlayerNamesMessage();
        try {
            Names names = new Names(inputView.readPlayerNames());
            return names.getNames();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return setPlayerNames();
        }
    }

    private LadderHeight setLadderHeight() {
        outputView.printLadderHeightMessage();
        try {
            return inputView.readLadderHeight();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }
}
