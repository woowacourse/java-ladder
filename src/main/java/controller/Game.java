package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.goal.Goals;
import domain.ladder.player.Players;
import util.BooleanGenerator;
import view.constant.Command;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class Game {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(BooleanGenerator booleanGenerator, InputView inputView, OutputView outputView) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = savePlayerNames();
        Goals goals = saveGoals(players.count());
        Ladder ladder = buildLadder(players, goals);

        printLadder(ladder);
        rideLadder(ladder);
    }

    private Players savePlayerNames() {
        try {
            outputView.printRequestNames();
            return Players.ofNames(inputView.getNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return savePlayerNames();
        }
    }

    private Goals saveGoals(int participantsSize) {
        try {
            outputView.printRequestGoals();
            return Goals.of(participantsSize, inputView.getGoals());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return saveGoals(participantsSize);
        }
    }

    private Ladder buildLadder(final Players players, final Goals goals) {
        Height height = saveHeight();
        Ladder ladder = Ladder.of(booleanGenerator, players, goals);
        ladder.build(height);
        return ladder;
    }

    private Height saveHeight() {
        try {
            outputView.printRequestLadderHeight();
            return Height.of(inputView.getHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return saveHeight();
        }
    }

    private void printLadder(final Ladder ladder) {
        outputView.printLadder(ladder.findPlayerNames(), ladder.findAllConnectedConditions(), ladder.findGoalNames());
    }

    private void rideLadder(Ladder ladder) {
        try {
            String playerName = getPlayerName();
            doRideLadder(ladder, playerName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            rideLadder(ladder);
        }
    }

    private void doRideLadder(Ladder ladder, String playerName) {
        if (playerName.equals(Command.ALL.getCommand())) {
            Map<String, String> rideResult = ladder.rideAll();
            outputView.printResult(rideResult);
            return;
        }

        String goalName = ladder.ride(playerName);
        outputView.printResult(playerName, goalName);
        rideLadder(ladder);
    }

    private String getPlayerName() {
        outputView.printRequestNameToRide();
        return inputView.getName();
    }
}
