import domain.Name;
import java.util.List;
import view.InputView;

public class LadderGame {

    public static void run() {
        List<Name> names = InputView.readPersonNames()
                .stream()
                .map(Name::new)
                .toList();
        int height = InputView.readHeight();
    }
}
