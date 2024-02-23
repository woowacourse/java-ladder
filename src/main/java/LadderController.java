import domain.Ladder;
import domain.Name;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class LadderController {

    public static void main(String[] args) throws IOException {
        final List<String> rawNames = InputView.readNames();
        final int height = InputView.readHeight();

        final List<Name> names = makeNames(rawNames);
        final Ladder ladder = new Ladder(names.size(), height);

        OutputView.printResult(names, ladder, height);
    }

    private static List<Name> makeNames(final List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }
}
