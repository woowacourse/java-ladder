import domain.Bridge;
import domain.LadderFactory;
import domain.Name;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {

    public static void main(String[] args) throws IOException {
        String[] names = InputView.readNames();
        int height = InputView.readHeight();

        List<Name> names1 = makeNames(names);
        List<Bridge> ladder = new LadderFactory().create(names1.size(), height);

        OutputView.printResult(names1, ladder, height);
    }

    private static List<Name> makeNames(String[] names) {
        return Arrays.stream(names)
                .map(Name::new)
                .toList();
    }

}
