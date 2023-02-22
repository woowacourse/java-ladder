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
            Names names = getNames();
            Missions missions = getMissions(names.size());

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
            String player = getPlayerToQuery();
            if (player.isBlank()) {
                return;
            }
            if (player.equals("all")) {
                outputView.printAllResult(ladderGame.findAllResult());
                return;
            }
            outputView.printSingleResult(ladderGame.findResultByName(player));
        }
    }

    private String getPlayerToQuery() {
        return inputView.readPlayer();
    }

    private void printLadder(Names names, Missions missions, Lines lines) {
        outputView.printResult(names, lines, missions);
    }

    private LadderMaker makeLadder(int lineNumber) {
        return LadderMaker.of(lineNumber, getHeight(), booleanGenerator);
    }

    private Names getNames() {
        return new Names(inputView.readNames());
    }

    private Missions getMissions(int size) {
        return new Missions(inputView.readMissions(), size);
    }

    private Height getHeight() {
        return new Height(inputView.readHeight());
    }
}
