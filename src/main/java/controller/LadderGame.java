package controller;

import domain.*;
import util.BooleanGenerator;
import util.RetryUtil;
import view.InputView;
import view.LadderShape;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final String OUTPUT_FORMAT = "%5s ";
    private static final String PRINT_ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        Participants participants = RetryUtil.retryUntilNoException(this::makeParticipants);
        Prizes prizes = RetryUtil.retryUntilNoException(() -> makePrize(participants));
        Ladder ladder = RetryUtil.retryUntilNoException(() -> makeLadder(participants.getParticipantsCount(), booleanGenerator));
        GameResult gameResult = new GameResult();

        printLadderOutput(ladder, participants, prizes);

        ladder.playLadder(gameResult, prizes, participants);
        printGameResultUntilEmptyName(participants, gameResult);
    }

    private Participants makeParticipants() {
        String input = inputView.inputName();

        return new Participants(List.of(input.split(",")));
    }

    private Prizes makePrize(Participants participants) {
        String input = inputView.inputResults();

        return new Prizes(input, participants.getParticipantsCount());
    }

    private Ladder makeLadder(int participantsCount, BooleanGenerator booleanGenerator) {
        String input = inputView.inputHeight();

        return Ladder.of(input, participantsCount, booleanGenerator);
    }

    private void printLadderOutput(Ladder ladder, Participants participants, Prizes prizes) {
        printParticipants(participants);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printParticipants(Participants participants) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int initPosition = 0; initPosition < participants.getParticipantsCount(); initPosition++) {
            String name = participants.findParticipantByInitPosition(initPosition).getName();

            stringBuilder.append(String.format(OUTPUT_FORMAT, name));
        }

        outputView.printParticipantLineUp(stringBuilder.toString());
    }

    private void printLadder(Ladder ladder) {
        List<String> output = new ArrayList<>();

        for (Line line : ladder.getLadder()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLineOutput(line, stringBuilder);

            output.add(stringBuilder.toString());
        }

        outputView.printLadderOutput(output);
    }

    private void createLineOutput(Line line, StringBuilder stringBuilder) {
        for (LadderItem point : line.getPoints()) {
            stringBuilder.append(LadderShape.getShapeByLadderItem(point));
        }
    }

    private void printPrizes(Prizes prizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String gameResult : prizes.getPrizes()) {
            stringBuilder.append(String.format(OUTPUT_FORMAT, gameResult));
        }

        outputView.printResultsOutput(stringBuilder.toString());
    }

    private void printGameResultUntilEmptyName(Participants participants, GameResult gameResult) {
        boolean keepInput = true;

        while (keepInput) {
            keepInput = RetryUtil.retryUntilNoException(() -> printGameResult(participants, gameResult));
        }
    }

    private boolean printGameResult(Participants participants, GameResult gameResult) {
        String name = inputView.inputResultName();
        boolean keepInput = !name.isEmpty();

        if (keepInput) {
            outputView.printResultsOutput(makeGameResult(name, participants, gameResult));
        }

        return keepInput;
    }

    private String makeGameResult(String name, Participants participants, GameResult gameResult) {
        if (name.equals(PRINT_ALL_COMMAND)) {
            return makeAllGameResult(gameResult);
        }

        Participant participant = participants.findParticipantByName(name);
        return gameResult.getResultByParticipant(participant);
    }

    private String makeAllGameResult(GameResult gameResult) {
        List<String> allResult = new ArrayList<>();

        for (Map.Entry<Participant, String> result : gameResult.getParticipantsResult().entrySet()) {
            allResult.add(result.getKey().getName() + " : " + result.getValue());
        }

        return String.join("\n", allResult);
    }
}
