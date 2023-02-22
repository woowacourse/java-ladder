package controller;

import domain.Height;
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

            Height height = getHeight();
            Players players = new Players(names);

            int lineNumber = names.getPersonNumber() - 1;
            Lines lines = new Lines(lineNumber, height.getHeight(), booleanGenerator);
            outputView.printResult(names, lines, missions);

            for (int index = 0; index < names.size(); index++) {
                Player player = players.findByIndex(index);
                player.move(lines);
            }

            players.distributeMissions(missions);

            printResult(players);

        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private Names getNames() {
        Names names = inputView.readNames();
        return names;
    }

    private Missions getMissions() {
        Missions missions = inputView.readMissions();
        return missions;
    }

    private Height getHeight() {
        Height height = inputView.readHeight();
        return height;
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

    private static void validateInputSize(Names names, Missions missions) {
        if (names.size() != missions.size()) {
            throw new IllegalArgumentException("참여자의 수와 미션의 수가 다릅니다!");
        }
    }
}
