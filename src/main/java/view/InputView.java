package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputView {

	private static final String NAME_SPLIT_DELIMITER = ",";

	private final Scanner scanner = new Scanner(System.in);

	public List<String> readPlayerNames() {
		List<String> playerNames = readNames();
		validateDuplicateName(playerNames);

		return playerNames;
	}

	public List<String> readPrizes(int playerCount) {
		List<String> prizeNames = readNames();
		validatePrizeCount(prizeNames, playerCount);

		return prizeNames;
	}

	public int readLadderHeight() {
		String input = scanner.nextLine();
		return convertToInteger(input);
	}

	public String readPlayersToGetPrize(List<String> playerNames) {
		String input = scanner.nextLine();
		if ("all".equals(input)) {
			return input;
		}
		if (isNotExistPlayerName(input, playerNames)) {
			throw new IllegalArgumentException("존재하지 않은 플레이어입니다.");
		}
		return input;
	}

	private void validateDuplicateName(List<String> playerNames) {
		Set<String> removedDuplicateNames = new HashSet<>(playerNames);
		boolean hasDuplicateName = removedDuplicateNames.size() != playerNames.size();
		if (hasDuplicateName) {
			throw new IllegalArgumentException("플레이어의 이름은 중복될 수 없습니다.");
		}
	}

	private List<String> readNames() {
		String names = scanner.nextLine();
		String[] splitNames = names.split(NAME_SPLIT_DELIMITER);

		return Arrays.stream(splitNames).toList();
	}

	private void validatePrizeCount(List<String> prizeNames, int playerCount) {
		if (prizeNames.size() != playerCount) {
			throw new IllegalArgumentException("결과 개수와 플레이어 수는 동일해야 합니다.");
		}
	}

	private int convertToInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("사다리 높이는 정수로 입력해야 합니다.");
		}
	}

	private boolean isNotExistPlayerName(String playerName, List<String> playerNames) {
		return !playerNames.contains(playerName);
	}
}
