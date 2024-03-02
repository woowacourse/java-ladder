import domain.Ladder;
import domain.Name;
import java.util.Map;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {

    static final String NAME_SEPARATOR = ",";

    public static void main(String[] args) throws IOException {
        OutputView.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", NAME_SEPARATOR);
        final List<Name> playerNames = makeNames();
        OutputView.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)\n", NAME_SEPARATOR);
        final List<Name> resultNames = makeNames();
        validationResultsSize(playerNames.size(), resultNames.size());
        OutputView.printf("최대 사다리 높이는 몇 개인가요?\n");
        final int height = InputView.readHeight();

        final Ladder ladder = new Ladder(playerNames.size(), height);

        OutputView.printResult(playerNames, resultNames, ladder);

        Map<Integer, Integer> allPlayerMatchResult = ladder.getAllMatch();

        playerMatchResult(playerNames, resultNames, allPlayerMatchResult);

    }

    private static void validationResultsSize(final int nameSize, final int resultSize) {
        if (nameSize != resultSize) {
            throw new IllegalArgumentException("사람 수와 결과물 수는 같아야 한다.");
        }
    }

    private static List<Name> makeNames() throws IOException {
        final List<String> names = InputView.readNames(NAME_SEPARATOR);

        return names.stream()
                .map(Name::new)
                .toList();
    }

    private static void playerMatchResult(List<Name> playerNames, List<Name> resultNames,
            Map<Integer, Integer> allPlayerMatchResult) throws IOException {
        while (true) {
            OutputView.printf("\n결과를 보고 싶은 사람은?\n");
            String rawNameForResult = InputView.readNameForResult();
            OutputView.printf("\n실행 결과\n");
            if ("all".equals(rawNameForResult)) {
                OutputView.printAllPlayerResult(playerNames, resultNames, allPlayerMatchResult);
                break;
            }
            Name nameForResult = new Name(rawNameForResult);
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
