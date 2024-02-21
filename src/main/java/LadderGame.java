import domain.Ladder;
import domain.Name;
import domain.RandomBridgeConstructStrategy;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public static void run() {
        List<Name> names = InputView.readPersonNames()
                .stream()
                .map(Name::new)
                .toList();
        int height = InputView.readHeight();
        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names.size(), height);

        OutputView.printNames(names);
        OutputView.printLadder(ladder);


    }
}
