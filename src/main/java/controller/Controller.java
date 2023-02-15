package controller;

import model.Ladder;
import model.LadderHeight;
import model.Player;
import model.Players;
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
        List<Player> playerNames = setPlayerNames();
        Ladder ladder = new Ladder(playerNames.size(),setLadderHeight());
        outputView.printPlayerName(playerNames);
        outputView.printLadder(playerNames.size(),ladder);
    }

    private List<Player> setPlayerNames(){
        outputView.printPlayerNamesMessage();
        try {
            Players players = new Players(inputView.readPlayerNames());
            return players.getPlayers();
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
