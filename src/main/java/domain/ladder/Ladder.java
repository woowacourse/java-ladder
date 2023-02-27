package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.end.End;
import domain.end.Ends;
import domain.user.User;
import domain.user.Users;
import domain.util.PointGenerator;

public class Ladder {
	private final Users users;
	private final Ends ends;
	private final List<Line> lines;
	private final LadderWidth ladderWidth;

	public Ladder(final Users users,
		final Ends ends,
		final LadderHeight ladderHeight,
		final PointGenerator pointGenerator) {

		this.users = users;
		this.ends = ends;
		this.lines = new ArrayList<>();
		this.ladderWidth = new LadderWidth(usersToWidth(users));

		int height = ladderHeight.getHeight();
		for (int i = 0; i < height; i++) {
			lines.add(new Line(ladderWidth.getWidth(), pointGenerator));
		}
	}

	private int usersToWidth(final Users users) {
		return users.getUsersCount() - 1;
	}

	public Map<User, End> getMappedResult() {
		List<Integer> movedIndex = getMovedIndex();
		Map<User, End> mappedResult = new LinkedHashMap<>();
		List<User> userList = users.getUsers();
		List<End> endList = ends.getEnds();
		int size = users.getUsersCount();
		for (int i = 0; i < size; i++) {
			mappedResult.put(userList.get(i), endList.get(movedIndex.get(i)));
		}
		return mappedResult;
	}

	private List<Integer> getMovedIndex() {
		List<Integer> indicies = getInitialIdx(ladderWidth.getWidth());
		for (Line line : lines) {
			indicies = line.moveThroughLine(indicies);
		}
		return indicies;
	}

	private List<Integer> getInitialIdx(final int size) {
		return IntStream.rangeClosed(0, size).boxed().collect(Collectors.toList());
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}
}
