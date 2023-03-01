package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.end.End;
import domain.end.Ends;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.user.User;
import domain.user.Users;
import domain.ladder.PointGenerator;

public class LadderGame {
	private static final int USERS_CNT_WIDTH_DIFFERENCE = 1;
	private final Users users;
	private final Ladder ladder;
	private final Ends ends;

	private LadderGame(final Users users, final Ladder ladder, final Ends ends) {
		this.users = users;
		this.ladder = ladder;
		this.ends = ends;
	}

	public static LadderGame create(final Users users,
		final Ends ends,
		final LadderHeight height,
		final PointGenerator generator) {
		int width = users.getUsersCount() - USERS_CNT_WIDTH_DIFFERENCE;
		Ladder ladder = Ladder.of(height.getHeight(), width, generator);
		return new LadderGame(users, ladder, ends);
	}

	public Map<User, End> getMappedResult() {
		List<Integer> movedIndex = ladder.getMovedIndex(users.getUsersCount() - USERS_CNT_WIDTH_DIFFERENCE);
		Map<User, End> mappedResult = new LinkedHashMap<>();
		List<User> userList = users.getUsers();
		List<End> endList = ends.getEnds();
		int size = users.getUsersCount();
		for (int i = 0; i < size; i++) {
			mappedResult.put(userList.get(i), endList.get(movedIndex.get(i)));
		}
		return mappedResult;
	}

	public Ladder getLadder() {
		return ladder;
	}
}
