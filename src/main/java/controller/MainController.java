package controller;

import domain.Height;
import domain.Lines;
import domain.Mission;
import domain.Missions;
import domain.Names;
import domain.Player;
import domain.Players;
import domain.Position;
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
            Names names = inputView.readNames();
            Missions missions = inputView.readMissions();
            Height height = inputView.readHeight();

            // TODO: 이름 수와 미션 수가 일치하지 않는 경우

            int lineNumber = names.getPersonNumber() - 1;
            Lines lines = new Lines(lineNumber, height.getHeight(), booleanGenerator);
            outputView.printResult(names, lines, missions);

            Players players = new Players();
            for (int index = 0; index < names.size(); index++) {
                Player player = new Player(names.getNameByIndex(index), new Position(index));
                players.addPlayer(player);
                Mission mission = missions.getMissionByIndex(player.getExitIndex(lines));
                player.setMission(mission);
            }

            Player player = players.findByName(inputView.readPlayer());
            outputView.printResult(player.getMission());

        } catch (Exception exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
