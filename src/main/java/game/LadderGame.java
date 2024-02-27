package game;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.HorizontalLineStatus;
import domain.Ladder;
import domain.LadderHeight;
import domain.Player;
import domain.Players;
import domain.Prize;
import domain.Prizes;
import generator.LadderFloorGenerator;

public class LadderGame {

	private final LadderFloorGenerator generator;
	private Ladder ladder;

	public LadderGame(LadderFloorGenerator generator) {
		this.generator = generator;
	}

	public Map<String, String> getAllPlayersPrizeNames(Players players, Prizes prizes) {
		Map<String, String> results = new LinkedHashMap<>();
		players.playAll(ladder);

		for (Player player : players.getPlayers()) {
			Prize prize = prizes.getPlayersPrize(player.getPosition());
			String prizeName = prize.getName();
			results.put(player.getName(), prizeName);
		}

		return results;
	}

	public String getOnePlayersPrizeName(Player player, Prizes prizes) {
		player.playLadder(ladder);
		Prize prize = prizes.getPlayersPrize(player.getPosition());

		return prize.getName();
	}

	public void createRandomLadder(int playerCount, LadderHeight height) {
		Ladder ladder = Ladder.of(playerCount, height.value());
		ladder.drawLines(generator);

		this.ladder = ladder;
	}

	public List<HorizontalLineStatus> getCurrentLadder() {
		return ladder.createStatuses();
	}
}