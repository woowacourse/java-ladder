package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    private final ScaffoldGenerator scaffoldGenerator;

    public LadderFactory(final ScaffoldGenerator scaffoldGenerator) {
        this.scaffoldGenerator = scaffoldGenerator;
    }

    public Ladder createLadder(final int width, final int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {

            List<Scaffold> scaffolds = new ArrayList<>();

            for (int j = 0; j < width; j++) {
                Scaffold scaffold = scaffoldGenerator.generate();

                if (scaffolds.isEmpty()) {
                    scaffolds.add(scaffold);
                    continue;
                }

                if (scaffold == Scaffold.EXIST && scaffolds.get(j - 1) == Scaffold.EXIST) {
                    scaffold = Scaffold.NONE;
                }
                scaffolds.add(scaffold);
            }

            lines.add(new Line(scaffolds));
        }
        return new Ladder(lines);
    }
}
