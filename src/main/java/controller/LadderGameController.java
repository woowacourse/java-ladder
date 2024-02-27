package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import domain.ladder.LadderGame;
import domain.ladder.LadderHeight;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LadderGame ladderGame;

	public LadderGameController(InputView inputView, OutputView outputView, LadderGame ladderGame) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.ladderGame = ladderGame;
	}

	public void run() {
		Players players = retryOnException(this::getPlayers);
		int playerCount = players.getPlayerCount();

		Prizes prizes = retryOnException(() -> getPrizes(playerCount));
		LadderHeight height = retryOnException(this::getHeight);

		ladderGame.createRandomLadder(playerCount, height);

		printCurrentLadder(players, prizes);
		printPlayerResult(players, prizes);
	}

	private Players getPlayers() {
		outputView.printReadNames();
		List<String> names = inputView.readNames();

		List<Player> players = new ArrayList<>();
		for (int order = 0; order < names.size(); order++) {
			Player player = new Player(names.get(order), order);
			players.add(player);
		}

		return new Players(players);
	}

	private Prizes getPrizes(int playerCount) {
		outputView.printReadPrizes();
		List<String> prizeNames = inputView.readPrizes(playerCount);

		return Prizes.fromNames(prizeNames);
	}

	private LadderHeight getHeight() {
		outputView.printReadLadderHeight();
		int height = inputView.readLadderHeight();

		return new LadderHeight(height);
	}

	private void printCurrentLadder(Players players, Prizes prizes) {
		outputView.printResultMessage();
		outputView.printNames(players.getPlayerNames());
		outputView.printLadder(ladderGame.getCurrentLadder());
		outputView.printNames(prizes.getPrizeNames());
		outputView.printEmptyLine();
	}

	private void printPlayerResult(Players players, Prizes prizes) {
		String playerName = retryOnException(() -> getPlayerNameToShowResult(players.getPlayerNames()));

		if (playerName.equals("all")) {
			printAllPlayersResult(players, prizes);
			return;
		}
		printOnePlayersResult(players, prizes, playerName);
	}

	private String getPlayerNameToShowResult(List<String> allPlayerNames) {
		outputView.printReadPlayer();
		return inputView.readPlayersToShowResult(allPlayerNames);
	}

	private void printAllPlayersResult(Players players, Prizes prizes) {
		Map<String, String> results = ladderGame.getAllPlayersPrizeNames(players, prizes);
		outputView.printAllPlayersResult(results);
	}

	private void printOnePlayersResult(Players players, Prizes prizes, String playerName) {
		Player player = players.findPlayerFromName(playerName);
		String result = ladderGame.getOnePlayersPrizeName(player, prizes);
		outputView.printOnePlayerResult(result);
	}

	private <T> T retryOnException(Supplier<T> function) {
		try {
			T result = function.get();
			outputView.printEmptyLine();
			return result;
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e.getMessage());
			return retryOnException(function);
		}
	}
}