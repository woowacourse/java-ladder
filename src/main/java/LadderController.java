import domain.Ladder;
import domain.Names;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class LadderController {

    public static void main(String[] args) throws IOException {
        final String[] rawNames = InputView.readNames();
        final int height = InputView.readHeight();

        final Names names = new Names(rawNames);
        final int width = names.names().size() - 1;
        final Ladder ladder = new Ladder(width, height);

        OutputView.printResult(names, ladder);
    }
}
