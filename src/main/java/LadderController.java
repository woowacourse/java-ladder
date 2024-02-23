import domain.Ladder;
import domain.Name;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LadderController {

    public static void main(String[] args) throws IOException {
        final String[] rawNames = InputView.readNames();
        final int height = InputView.readHeight();

        final List<Name> names = makeNames(rawNames);
        final Ladder ladder = new Ladder(names.size() - 1, height);

        OutputView.printResult(names, ladder);
    }

    private static List<Name> makeNames(final String[] names) {
        return Arrays.stream(names)
                .map(Name::new)
                .toList();
    }
}
