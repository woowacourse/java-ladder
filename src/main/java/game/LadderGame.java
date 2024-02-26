package game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import domain.HorizontalLineStatus;
import domain.Ladder;
import domain.LadderHeight;
import domain.Player;
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
		List<Player> players = retryOnException(this::getPlayers);
		List<Prize> prizes = retryOnException(() -> getPrizes(players.size()));
		LadderHeight height = retryOnException(this::getHeight);

		Ladder ladder = Ladder.of(players.size(), height.value());
		ladder.drawLines(floorGenerator);
		List<HorizontalLineStatus> statuses = ladder.createStatuses();

		printLadderResult(players, statuses, prizes);
	}

	private List<Player> getPlayers() {
		outputView.printReadNames();
		List<String> names = inputView.readNames();

		List<Player> result = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			Player player = new Player(names.get(i), i);
			result.add(player);
		}

		return result;
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
		List<Player> players,
		List<HorizontalLineStatus> statuses,
		List<Prize> prizes
	) {
		outputView.printResultMessage();
		outputView.printNames(convertNames(players));
		outputView.printLadder(statuses);
		outputView.printNames(convertPrizes(prizes));
	}

	private List<String> convertNames(List<Player> players) {
		return players.stream()
			.map(Player::getName)
			.toList();
	}

	private List<String> convertPrizes(List<Prize> prizes) {
		return prizes.stream()
			.map(Prize::getName)
			.toList();
	}

	private <T> T retryOnException(Supplier<T> function) {
		try {
			return function.get();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e.getMessage());
			return retryOnException(function);
		}
	}
}
