package controller;

import model.Game;
import model.Ladder;
import model.LadderHeight;
import model.LadderResult;
import model.Names;
import model.Player;
import util.LineGenerator;
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
        Ladder ladder = new Ladder(names.getNamesSize(), ladderHeight,new LineGenerator());
        Game game = new Game(names, ladderResult,ladderHeight,ladder);
        printLadder(names, ladder, ladderHeight , ladderResult);
        playLadderGame(game,names);
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
        outputView.printExecutionResultMessage();
        try {
            return new LadderResult(inputView.readLadderResult(),personCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setLadderResult(personCount);
        }
    }

    private void printLadder(Names names, Ladder ladder, LadderHeight ladderHeight,
                             LadderResult result){
        outputView.printLadderResultMessage();
        outputView.printName(names);
        outputView.printLadder(names, ladder, ladderHeight);
        outputView.printResult(result);
    }

    private void playLadderGame(Game game,Names names) {
        Player playerName;
        do{
            playerName = setPlayer(names);
            outputView.printPlayerExecutionResultMessage();
            printPlayerResult(playerName, game);
        }
        while(!playerName.isEqualPlayer(playerName));
    }

    private Player setPlayer(Names names) {
        outputView.printPlayerResultMessage();
        try {
            return new Player(names, inputView.readPlayerResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setPlayer(names);
        }
    }

    private void printPlayerResult(Player player,Game game){
        if(player.isExistPlayer(player)){
            outputView.printPlayerGameResult(game.getPrizeIndividualPlayer(player).getResult());
            return;
        }
        outputView.printPlayerGameEndResult(game.getPrizePlayers());
    }
}
