package domain;

import java.util.ArrayList;
import java.util.List;

import generator.LadderFloorGenerator;

public class Ladder {

	private final List<HorizontalLine> lines;
	private final List<Prize> prizes;

	private Ladder(int playerCount, int height, List<Prize> prizes) {
		this.lines = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			lines.add(new HorizontalLine(playerCount));
		}

		this.prizes = prizes;
	}

	public static Ladder of(int playerCount, int height, List<Prize> prizes) {
		return new Ladder(playerCount, height, prizes);
	}

	public void drawLines(LadderFloorGenerator generator) {
		lines.forEach(line -> line.createCrossingLines(generator));
	}

	public List<HorizontalLineStatus> createStatuses() {
		return lines.stream()
			.map(HorizontalLine::createStatus)
			.toList();
	}

	public Prize play(Player player) {
		for (HorizontalLine line : lines) {
			player.move(line);
		}

		return prizes.get(player.getPosition());
	}
}
