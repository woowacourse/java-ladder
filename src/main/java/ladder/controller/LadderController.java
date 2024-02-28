package ladder.controller;

import java.util.List;
import java.util.function.Supplier;
import ladder.domain.GameResult;
import ladder.domain.Prizes;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RungGenerator;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static final String ALL_RESULT_INPUT_KEYWORD = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final RungGenerator rungGenerator;

    public LadderController(InputView inputView, OutputView outputView, RungGenerator rungGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rungGenerator = rungGenerator;
    }

    public void run() {
        Participants participants = repeatUntilValid(this::getParticipants);
        int participantsCount = participants.getCount();
        Prizes prizes = repeatUntilValid(() -> getPrizes(participantsCount));
        Ladder ladder = repeatUntilValid(() -> getLadder(participantsCount));
        printLadderResult(participants, prizes, ladder);

        Prizes sortedPrizes = ladder.getSortedPrizesResult(participants, prizes);
        GameResult gameResult = new GameResult(participants, sortedPrizes);
        String name = repeatUntilValid(() -> getName(gameResult));
        printLadderGameResult(gameResult, name);
    }


    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeatUntilValid(function);
        }
    }

    private Participants getParticipants() {
        List<String> inputNames = inputView.getNames();
        return new Participants(inputNames);
    }

    private Ladder getLadder(int participantsCount) {
        int height = inputView.getHeight();
        return new Ladder(height, participantsCount, rungGenerator);
    }

    private Prizes getPrizes(int participantsCount) {
        List<String> prizeNames = inputView.getPrizeNames();
        return new Prizes(prizeNames, participantsCount);
    }

    private void printLadderResult(Participants participants, Prizes prizes, Ladder ladder) {
        LadderResponseDto ladderResponseDto = ladder.getLadderResult();
        outputView.printLadderResult(ladderResponseDto, participants.getNames(), prizes.getNames());
    }

    private String getName(GameResult gameResult) {
        String name = inputView.getName();

        if (name.equals(ALL_RESULT_INPUT_KEYWORD)) {
            return name;
        }
        gameResult.containsName(name);
        return name;
    }

    private void printLadderGameResult(GameResult gameResult, String nameSearch) {
        if (nameSearch.equals(ALL_RESULT_INPUT_KEYWORD)) {
            outputView.printAllMatchResult(gameResult.getGameResult());
        }

        if (!nameSearch.equals(ALL_RESULT_INPUT_KEYWORD)) {
            outputView.printNameMatchResult(gameResult.getGameResult(), nameSearch);
        }
    }
}
