import domain.Ladder;
import domain.Name;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {

    public static void main(String[] args) throws IOException {
        final List<Name> names = makeNames();
        final List<Name> results = makeResult();
        validationResultsSize(names.size(), results.size());
        final int height = InputView.readHeight();

        final Ladder ladder = new Ladder(names.size(), height);

        OutputView.printResult(names, ladder);
    }

    private static void validationResultsSize(final int nameSize, final int resultSize) {
        if (nameSize != resultSize) {
            throw new IllegalArgumentException("사람 수와 결과물 수는 같아야 한다.");
        }
    }

    private static List<Name> makeNames() throws IOException {
        final List<String> names = InputView.readNames();

        return names.stream()
                .map(Name::new)
                .toList();
    }

    private static List<Name> makeResult() throws IOException {
        final List<String> results = InputView.readResults();

        return results.stream()
                .map(Name::new)
                .toList();
    }
}
