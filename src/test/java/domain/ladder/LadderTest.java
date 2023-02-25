package domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.end.End;
import domain.end.Ends;
import domain.user.User;
import domain.user.Users;
import domain.util.PointGenerator;

class LadderTest {
	private final Users users = new Users(List.of("userA", "userB", "userC", "userD"));
	private final Ends ends = new Ends(List.of("end1", "end2", "end3", "end4"), 4);
	private final LadderHeight height = new LadderHeight(3);

	@Test
	@DisplayName("사다리 생성 테스트")
	void buildLadderTest() {

		Ladder ladder = new Ladder(users, ends, height, new PresentPointGenerator());
		List<List<Point>> points2D = changeToPoints2D(ladder);

		assertThat(points2D).containsExactly(
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			),
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			),
			List.of(
				Point.PRESENCE, Point.ABSENCE, Point.PRESENCE
			));
	}

	private List<List<Point>> changeToPoints2D(Ladder ladder) {
		List<Line> lines = ladder.getLines();
		return lines.stream()
			.map(Line::getPoints)
			.collect(Collectors.toList());
	}

	@ParameterizedTest
	@DisplayName("1, 0, 3, 2의 순서로 매칭된 결과가 나와야 한다.")
	@CsvSource({"0,1", "1,0", "2,3", "3,2"})
	void getMappedResultTest(int originalIdx, int changedIdx) {
		Ladder ladder = new Ladder(users, ends, height, new PresentPointGenerator());
		Map<User, End> mappedResult = ladder.getMappedResult();
		List<User> usersList = users.getUsers();
		List<End> endsList = ends.getEnds();

		User user = usersList.get(originalIdx);
		End end = endsList.get(changedIdx);
		Assertions.assertThat(mappedResult.get(user)).isEqualTo(end);
	}

	static class PresentPointGenerator implements PointGenerator {
		@Override
		public Point generate() {
			return Point.PRESENCE;
		}
	}
}
