package controller;

import domain.Height;
import domain.LadderGame;
import domain.LadderMaker;
import domain.Lines;
import domain.Missions;
import domain.Names;
import domain.Players;
import domain.generator.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;


    public MainController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        try {
            Names names = getNames();
            Missions missions = getMissions(names.size());

            int lineNumber = names.getPersonNumber() - 1;
            LadderMaker ladderMaker = makeLadder(lineNumber);
            printLadder(names, missions, ladderMaker.getLines());

            Players players = new Players(names);
            LadderGame ladderGame = LadderGame.of(players, missions, ladderMaker.getLines());

            String receivedPlayer = inputView.readPlayer();

            if (receivedPlayer.equals("all")) {
                outputView.printAllResult(ladderGame.findAllResult());
            }
            if (!receivedPlayer.equals("all")) {
                outputView.printSingleResult(ladderGame.findResultByName(receivedPlayer));
            }

        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void printLadder(Names names, Missions missions, Lines lines) {
        outputView.printResult(names, lines, missions);
    }

    private LadderMaker makeLadder(int lineNumber) {
        return LadderMaker.of(lineNumber, getHeight(), booleanGenerator);
    }

    private Names getNames() {
        return inputView.readNames();
    }

    private Missions getMissions(int size) {
        return new Missions(inputView.readMissions(), size);
    }

    private Height getHeight() {
        return inputView.readHeight();
    }


}
