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
import ladder.domain.result.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String SEARCH_ALL_KEYWORD = "all";

    public void run() {
        Players players = initPlayers();
        int playerNumber = players.size();
        Prizes prizes = initPrizes(playerNumber);
        Ladder ladder = initLadder(playerNumber);

        showDrawnResult(players, prizes, ladder);
        showAnalyzedResult(players, prizes, ladder);
        InputView.terminate();
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

    private Prizes initPrizes(final int playerNumber) {
        try {
            List<String> prizeNames = InputView.inputPrize();
            return new Prizes(playerNumber, prizeNames);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initPrizes(playerNumber);
        }
    }

    private Ladder initLadder(final int playerNumber) {
        try {
            final int height = InputView.inputLadderHeight();
            BlockGenerator blockGenerator = new RandomBlockGenerator();
            return new Ladder(blockGenerator, playerNumber, height);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initLadder(playerNumber);
        }
    }

    private void showDrawnResult(final Players players, final Prizes prizes, final Ladder ladder) {
        OutputView.printGameResultHeader();
        printPlayersName(players);
        OutputView.printLadder(toLines(ladder));
        printPrizesName(prizes);
    }

    private void printPlayersName(final Players players) {
        List<String> playersName = toPlayersName(players);
        OutputView.printPlayersName(playersName);
    }

    private List<String> toPlayersName(final Players players) {
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

    private void showAnalyzedResult(Players players, Prizes prizes, Ladder ladder) {
        Result result = new Result(players, prizes, ladder);
        searchResult(result, players);
    }

    private void searchResult(Result result, Players players) {
        try {
            chooseSearchOption(result, players);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            searchResult(result, players);
        }
    }

    private void chooseSearchOption(Result result, Players players) {
        String input = InputView.inputPlayerResult();
        while (!input.equals(SEARCH_ALL_KEYWORD)) {
            showSinglePlayerResult(result, players, input);
            input = InputView.inputPlayerResult();
        }
        showAllPlayersResult(result);
    }

    private void showResult(Result result, Players players, String input) {
        if (input.equals(SEARCH_ALL_KEYWORD)) {
            showAllPlayersResult(result);
            return;
        }
        showSinglePlayerResult(result, players, input);
    }

    private void showAllPlayersResult(Result result) {
        OutputView.printPlayerResultHeaderMessage();
        Map<String, String> resultForView = new LinkedHashMap<>();
        Map<PlayerName, Prize> results = result.getAllResult();
        for (PlayerName playerName : results.keySet()) {
            String prizeName = results.get(playerName).getName();
            resultForView.put(playerName.getName(), prizeName);
        }
        OutputView.printAllResults(resultForView);
    }

    private void showSinglePlayerResult(Result result, Players players, String name) {
        OutputView.printPlayerResultHeaderMessage();
        PlayerName playerName = players.findByName(name);
        Prize prize = result.getSinglePlayerResult(playerName);
        OutputView.printSingleResult(prize.getName());
    }
}
