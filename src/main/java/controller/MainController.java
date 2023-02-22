package controller;

import domain.LadderGame;
import domain.LadderMaker;
import domain.generator.BooleanGenerator;
import domain.ladder.Height;
import domain.ladder.Lines;
import domain.mission.Missions;
import domain.player.Names;
import domain.player.Players;
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
            Names names = new Names(inputView.readNames());
            Missions missions = new Missions(inputView.readMissions(), names.size());

            int lineNumber = names.getPersonNumber() - 1;
            LadderMaker ladderMaker = makeLadder(lineNumber);
            printLadder(names, missions, ladderMaker.getLines());

            Players players = new Players(names);
            LadderGame ladderGame = LadderGame.of(players, missions, ladderMaker.getLines());

            queryResult(ladderGame);
        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void queryResult(LadderGame ladderGame) {
        while (true) {
            String player = inputView.readPlayer();
            if (player.isBlank()) {
                return;
            }
            if (showAll(player)) {
                outputView.printAllResult(ladderGame.findAllResult());
                return;
            }
            outputView.printSingleResult(ladderGame.findResultByName(player));
        }
    }

    private static boolean showAll(String player) {
        return player.equals("all");
    }

    private void printLadder(Names names, Missions missions, Lines lines) {
        outputView.printResult(names, lines, missions);
    }

    private LadderMaker makeLadder(int lineNumber) {
        return LadderMaker.of(lineNumber, new Height(inputView.readHeight()), booleanGenerator);
    }
}
