package domain.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {
	private final List<Line> lines;
	private final int height;
	private final int width;

	public Ladder(final List<Line> lines) {
		this.lines = lines;
		this.height = lines.size();
		this.width = lines.get(0).size();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
