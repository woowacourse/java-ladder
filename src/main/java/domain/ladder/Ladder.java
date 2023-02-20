package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {
	private final List<Line> lines;
	private final LadderHeight height;
	private final LadderWidth width;

	public Ladder(final List<Line> lines) {
		this.lines = lines;
		this.height = new LadderHeight(lines.size());
		this.width = new LadderWidth(lines.get(0).size());
	}

	public LadderHeight getHeight() {
		return height;
	}

	public LadderWidth getWidth() {
		return width;
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
