package controller;

import domain.game.GameResults;
import domain.game.LadderGameResults;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.PlayerNames;
import domain.player.Players;
import dto.LadderGameResultDto;
import dto.LadderStatus;
import util.ConsoleReader;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGameMachine {
    private static final ConsoleReader CONSOLE = new ConsoleReader();

    public void run() {
        PlayerNames playerNames = initNames();
        GameResults gameResults = initGameResults();
        LadderHeight ladderHeight = initLadderHeight();
        Ladder ladder = initLadder(new RandomBooleanGenerator(), ladderHeight, playerNames);
        OutputView.printLadderResult(LadderStatus.of(playerNames, ladder, gameResults));
        printLadderGameResults(ladder, ladderHeight, gameResults, playerNames);
    }

    private PlayerNames initNames() {
        try {
            List<String> input = InputView.readStringsWithDelimiter(CONSOLE, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return PlayerNames.of(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initNames();
        }
    }

    private GameResults initGameResults() {
        try {
            List<String> input = InputView.readStringsWithDelimiter(CONSOLE, "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            return GameResults.of(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initGameResults();
        }
    }

    private LadderHeight initLadderHeight() {
        try {
            int input = InputView.readNumber(CONSOLE, "최대 사다리 높이는 몇 개인가요?");
            return new LadderHeight(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initLadderHeight();
        }
    }

    private Ladder initLadder(final Supplier<Boolean> generator, final LadderHeight ladderHeight, final PlayerNames playerNames) {
        return Ladder.of(generator, ladderHeight, playerNames.getPlayerCount());
    }

    private void printLadderGameResults(
            final Ladder ladder,
            final LadderHeight ladderHeight,
            final GameResults gameResults,
            final PlayerNames playerNames
    ) {
        Players players = Players.of(playerNames, ladderHeight);
        LadderGameResults ladderGameResults = LadderGameResults.of(ladder, players, gameResults);
        boolean isContinue = true;

        while (isContinue) {
            List<LadderGameResultDto> playerLadderGameResults = findPlayerLadderGameResults(ladderGameResults);
            OutputView.printLadderGameResults(playerLadderGameResults);
            isContinue = switchLoopStatus(playerLadderGameResults);
        }
    }

    private List<LadderGameResultDto> findPlayerLadderGameResults(final LadderGameResults ladderGameResults) {
        try {
            String inputName = InputView.inputString(CONSOLE, "결과를 보고 싶은 사람은?");
            return ladderGameResults.findPlayerGameResults(inputName)
                    .stream()
                    .map(LadderGameResultDto::of)
                    .toList();
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return findPlayerLadderGameResults(ladderGameResults);
        }
    }

    private boolean switchLoopStatus(final List<LadderGameResultDto> playerLadderGameResults) {
        return playerLadderGameResults.size() == 1;
    }
}
