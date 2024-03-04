package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.Name;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;
import java.util.List;
import java.io.IOException;

public class Game {

    private static final String NAME_SEPARATOR = ",";
    private final List<Name> playerNames;
    private final List<Name> resultNames;
    private final Ladder ladder;

    public Game() throws IOException {
        playerNames = getPlayerNames();
        resultNames = getResultNames();
        validationResultsSize();
        ladder = new Ladder(playerNames.size(), getHeight());
    }

    public void run() throws IOException {
        OutputView.printResult(playerNames, resultNames, ladder);

        displayPlayerMatchResult(ladder.getAllMatch());
    }

    private List<Name> getPlayerNames() throws IOException {
        OutputView.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", NAME_SEPARATOR);
        return makeNames();
    }

    private List<Name> getResultNames() throws IOException {
        OutputView.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)\n", NAME_SEPARATOR);
        return makeNames();
    }

    private void validationResultsSize() {
        if (playerNames.size() != resultNames.size()) {
            throw new IllegalArgumentException("사람 수와 결과물 수는 같아야 한다.");
        }
    }

    private int getHeight() throws IOException {
        OutputView.printf("최대 사다리 높이는 몇 개인가요?\n");
        return InputView.readHeight();
    }

    private List<Name> makeNames() throws IOException {
        final List<String> names = InputView.readNames(NAME_SEPARATOR);

        return names.stream()
                .map(Name::new)
                .toList();
    }

    private void displayPlayerMatchResult(Map<Integer, Integer> allPlayerMatchResult) throws IOException {
        while (true) {
            OutputView.printf("\n결과를 보고 싶은 사람은?\n");
            Name nameForResult = new Name(InputView.readNameForResult());
            OutputView.printf("\n실행 결과\n");
            if ("all".equals(nameForResult.name())) {
                OutputView.printAllPlayerResult(playerNames, resultNames, allPlayerMatchResult);
                break;
            }
            if (playerNames.contains(nameForResult)) {
                final int resultIndex = allPlayerMatchResult.get(playerNames.indexOf(nameForResult));
                final Name result = resultNames.get(resultIndex);
                OutputView.printf("%s\n", result.name());
                continue;
            }
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
    }
}
