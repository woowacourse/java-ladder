package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.generator.RungGenerator;

public class Floor {
    private final RungGenerator rungGenerator;
    private final Rungs rungs;

    public Floor(int playerCount, RungGenerator rungGenerator) {
        this.rungGenerator = rungGenerator;
        this.rungs = generateRungs(playerCount);
    }

    public Rungs generateRungs(int playerCount) {
        List<Rung> rungs = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            Rung rung = generateRung(rungs);
            rungs.add(rung);
        }

        return new Rungs(rungs);
    }

    private Rung generateRung(List<Rung> rungs) {
        if (shouldGenerateExistRung(rungs, rungGenerator.generate())) {
            return Rung.EXIST;
        }

        return Rung.EMPTY;
    }

    private static boolean shouldGenerateExistRung(List<Rung> rungs, Rung currentRung) {
        boolean previousRungIsEmpty = rungs.isEmpty() || rungs.get(rungs.size() - 1).isEmpty();

        return previousRungIsEmpty && currentRung.isExist();
    }

    public int findConnectedIndex(int index) {
        return rungs.findConnectedIndex(index);
    }

    public List<Rung> getRungs() {
        return rungs.getRungs();
    }
}
