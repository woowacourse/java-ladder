package controller;

import domain.Height;
import domain.LadderGame;
import domain.LadderMaker;
import domain.Lines;
import domain.Missions;
import domain.Names;
import domain.Player;
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
            Missions missions = getMissions();
            validateInputSize(names, missions);

            int lineNumber = names.getPersonNumber() - 1;
            LadderMaker ladderMaker = makeLadder(lineNumber);
            printLadder(names, missions, ladderMaker.getLines());

            Players players = new Players(names);
            LadderGame ladderGame = LadderGame.of(players, missions, ladderMaker.getLines());

            printResult(players);

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

    private void printResult(Players players) {
        if (inputView.readPlayer().equals("all")) {
            outputView.printAllResult(players);
        }
        if (!inputView.readPlayer().equals("all")) {
            Player player = players.findByName(inputView.readPlayer());
            outputView.printPlayerResult(player.getMission());
        }
    }

    private Names getNames() {
        return inputView.readNames();
    }

    private Missions getMissions() {
        return inputView.readMissions();
    }

    private Height getHeight() {
        return inputView.readHeight();
    }


    private static void validateInputSize(Names names, Missions missions) {
        if (names.size() != missions.size()) {
            throw new IllegalArgumentException("참여자의 수와 미션의 수가 다릅니다!");
        }
    }
}
