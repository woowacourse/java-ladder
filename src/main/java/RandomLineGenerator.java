import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    @Override
    public List<Boolean> getLine(int peopleNumber) {

        List<Boolean> line = new ArrayList<>();
        Boolean before = Boolean.FALSE;

        for (int i = 0; i < peopleNumber - 1; i++) {
            if (before) {
                line.add(false);
            }
            if (!before) {
                line.add(Math.random() >= 0.5);
            }
            before = line.get(i);
        }

        return line;
    }
}
