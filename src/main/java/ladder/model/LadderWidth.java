package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class LadderWidth {

    private static final String PIPE = "|";
    private List<LadderCrossbar> crossbars;

    public LadderWidth(List<LadderCrossbar> crossbars) {
        this.crossbars = crossbars;
    }

    public LadderWidth(int width) {
        this.crossbars = generateLadderWidth(width);
    }

    private List<LadderCrossbar> generateLadderWidth(int width) {
        List<LadderCrossbar> crossbars = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            crossbars.add(new LadderCrossbar());
        }
        AtomicBoolean beforeIndex = new AtomicBoolean(false);
        return crossbars.stream().peek(index -> {
            checkBeforeCrossbar(beforeIndex, index);
        }).collect(Collectors.toList());
    }

    private void checkBeforeCrossbar(AtomicBoolean beforeIndex, LadderCrossbar index) {
        if(beforeIndex.get() && index.exist()){
            index.changeCrossbarValue();
        }
        beforeIndex.set(index.exist());
    }

    @Override
    public String toString() {
        return PIPE + crossbars.stream().map(LadderCrossbar::toString).collect(Collectors.joining(PIPE)) + PIPE;
    }
}
