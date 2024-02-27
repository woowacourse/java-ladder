package game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import domain.HorizontalLineStatus;
import domain.Ladder;
import domain.LadderHeight;
import domain.Player;
import domain.Players;
import domain.Prize;
import generator.LadderFloorGenerator;
import view.InputView;
import view.OutputView;

public class LadderGame {

	private final InputView inputView;
	private final OutputView outputView;
	private final LadderFloorGenerator floorGenerator;

	public LadderGame(InputView inputView, OutputView outputView, LadderFloorGenerator floorGenerator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.floorGenerator = floorGenerator;
	}

	public void play() {
		Players players = retryOnException(this::getPlayers);
		List<Prize> prizes = retryOnException(() -> getPrizes(players.getPlayerCount()));
		LadderHeight height = retryOnException(this::getHeight);

		Ladder ladder = Ladder.of(players.getPlayerCount(), height.value(), prizes);
		ladder.drawLines(floorGenerator);
		List<HorizontalLineStatus> statuses = ladder.createStatuses();

		printLadderResult(players, statuses, prizes);
		printPlayerResult(players, ladder);
	}

	private void printPlayerResult(Players players, Ladder ladder) {
		outputView.printReadPlayer();
		String playerName = retryOnException(() -> inputView.readPlayersToShowResult(players.getPlayerNames()));
		if (playerName.equals("all")) {
			outputView.printAllPlayersResult(players.playGhostLeg(ladder));
			return;
		}
		Player player = players.findPlayerFromName(playerName);
		Prize prize = ladder.play(player);
		outputView.printOnePlayerResult(prize.getName());
	}

	private Players getPlayers() {
		outputView.printReadNames();
		List<String> names = inputView.readNames();

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			Player player = new Player(names.get(i), i);
			players.add(player);
		}

		return new Players(players);
	}

	private List<Prize> getPrizes(int playerCount) {
		outputView.printReadPrizes();
		List<String> prizeNames = inputView.readPrizes(playerCount);

		return prizeNames.stream()
			.map(Prize::new)
			.toList();
	}

	private LadderHeight getHeight() {
		outputView.printReadLadderHeight();
		int height = inputView.readLadderHeight();

		return new LadderHeight(height);
	}

	private void printLadderResult(
		Players players,
		List<HorizontalLineStatus> statuses,
		List<Prize> prizes
	) {
		outputView.printResultMessage();
		outputView.printNames(players.getPlayerNames());
		outputView.printLadder(statuses);
		outputView.printNames(convertPrizes(prizes));
		outputView.printEmptyLine();
	}

	private List<String> convertPrizes(List<Prize> prizes) {
		return prizes.stream()
			.map(Prize::getName)
			.toList();
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