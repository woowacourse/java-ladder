package ladder.controller;

import ladder.common.CustomException;
import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.ladder.generator.RandomBlockGenerator;
import ladder.domain.player.PlayerName;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    public void run() {
        Players players = initPlayers();
        int playerNumber = players.size();
        Prizes prizes = initPrizes(playerNumber);
        Ladder ladder = initLadder(playerNumber);

        showLadderResult(players, ladder, prizes);
        showPlayerResult(players, prizes, ladder);
        InputView.terminate();
    }

    private void showPlayerResult(Players players, Prizes prizes, Ladder ladder) {
        String input = InputView.inputPlayerResult();
    }

    private Players initPlayers() {
        try {
            List<String> playerNames = InputView.inputPlayer();
            return new Players(playerNames);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initPlayers();
        }
    }

    private Prizes initPrizes(int playerNumber) {
        try {
            List<String> prizeNames = InputView.inputPrize();
            return new Prizes(playerNumber, prizeNames);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initPrizes(playerNumber);
        }
    }

    private Ladder initLadder(int playerNumber) {
        try {
            final int height = InputView.inputLadderHeight();
            BlockGenerator blockGenerator = new RandomBlockGenerator();
            return new Ladder(blockGenerator, playerNumber, height);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initLadder(playerNumber);
        }
    }

    private void showLadderResult(Players players, Ladder ladder, Prizes prizes) {
        OutputView.printGameResultHeader();
        printPlayersName(players);
        OutputView.printLadder(toLines(ladder));
        printPrizesName(prizes);
    }

    private void printPlayersName(Players players) {
        List<String> playersName = toPlayersName(players);
        OutputView.printPlayersName(playersName);
    }

    private List<String> toPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(PlayerName::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<List<Boolean>> toLines(Ladder ladder) {
        return ladder.getLines().stream()
                .map(this::toBlocks)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Boolean> toBlocks(Line line) {
        return line.getBlocks().stream()
                .map(Block::isExistBlock)
                .collect(Collectors.toUnmodifiableList());
    }

    private void printPrizesName(Prizes prizes) {
        List<String> prizesName = toPrizesName(prizes);
        OutputView.printPrizesName(prizesName);
    }

    private List<String> toPrizesName(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(Prize::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
